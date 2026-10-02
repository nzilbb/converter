//
// Copyright 2026 New Zealand Institute of Language, Brain and Behaviour, 
// University of Canterbury
// Written by Robert Fromont - robert.fromont@canterbury.ac.nz
//
//    This file is part of nzilbb.ag.
//
//    nzilbb.ag is free software; you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation; either version 3 of the License, or
//    (at your option) any later version.
//
//    nzilbb.ag is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with nzilbb.ag; if not, write to the Free Software
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
package nzilbb.converter;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Optional;
import nzilbb.ag.Constants;
import nzilbb.ag.Graph;
import nzilbb.ag.Annotation;
import nzilbb.ag.Layer;
import nzilbb.ag.Schema;
import nzilbb.ag.serialize.GraphDeserializer;
import nzilbb.ag.serialize.GraphSerializer;
import nzilbb.encoding.HTK2DISC;
import nzilbb.formatter.praat.TextGridSerialization;
import nzilbb.formatter.htk.mlf.MlfDeserializer;
import nzilbb.util.ProgramDescription;
import nzilbb.util.Switch;

/**
 * Converts HTK .mlf utterances to Praat TextGrid files.
 * @author Robert Fromont robert@fromont.net.nz
 */
@ProgramDescription(value="Converts HTK .mlf files to Praat .TextGrid files",arguments="file.mlf ...")
public class MlfToTextGrid extends Converter {

  /**
   * Default constructor.
   */
  public MlfToTextGrid() {
    normalizer = null;
    sourceUrl = "https://github.com/nzilbb/converter/tree/main/mlftotextgrid";
  } // end of constructor
  
  /**
   * Whether to removing the leading underscore _ from segment labels.
   * @see #getRemoveHtkSegmentPrefix()
   * @see #setRemoveHtkSegmentPrefix(Boolean)
   */
  protected Boolean removeHtkSegmentPrefix = Boolean.TRUE;
  /**
   * Getter for {@link #removeHtkSegmentPrefix}: Whether to removing
   * the leading underscore _ from segment labels. 
   * @return Whether to removing the leading underscore _ from segment labels.
   */
  public Boolean getRemoveHtkSegmentPrefix() { return removeHtkSegmentPrefix; }
  /**
   * Setter for {@link #removeHtkSegmentPrefix}: Whether to removing
   * the leading underscore _ from segment labels. 
   * @param newRemoveHtkSegmentPrefix Whether to removing the leading
   * underscore _ from segment labels. 
   */
  @Switch(value="Whether to removing the leading underscore _ from segment labels",compulsory=false)
  public MlfToTextGrid setRemoveHtkSegmentPrefix(Boolean newRemoveHtkSegmentPrefix) { removeHtkSegmentPrefix = newRemoveHtkSegmentPrefix; return this; }
  
  /**
   * The speaker ID to use for all utterances.
   * @see #getSpeakerId()
   * @see #setSpeakerId(String)
   */
  protected String speakerId;
  /**
   * Getter for {@link #speakerId}: The speaker ID to use for all utterances.
   * @return The speaker ID to use for all utterances.
   */
  public String getSpeakerId() { return speakerId; }
  /**
   * Setter for {@link #speakerId}: The speaker ID to use for all utterances.
   * @param newSpeakerId The speaker ID to use for all utterances.
   */
  @Switch(value="The speaker ID to use for all utterances",compulsory=false)
  public MlfToTextGrid setSpeakerId(String newSpeakerId) { speakerId = newSpeakerId; return this; }
  
  public static void main(String argv[]) {
    new MlfToTextGrid().mainRun(argv);
  }
  
  /** File filter for identifying files of the correct type */
  protected FileNameExtensionFilter getFileFilter() {
    return new FileNameExtensionFilter("HTK Master Label Files", "mlf");
  }

  /**
   * Gets the deserializer that #convert(File) uses.
   * @return The deserializer to use.
   */
  public GraphDeserializer getDeserializer() {
    return new MlfDeserializer();
  }
  
  /**
   * Gets the serializer that #convert(File) uses.
   * @return The serializer to use.
   */
  public GraphSerializer getSerializer() {
    return new TextGridSerialization();
  }
  
  /**
   * Specify the schema to used by  {@link #convert(File)}.
   * @return The schema.
   */
  public Schema getSchema() {
    Schema schema = super.getSchema();
    // include MLF layers
    schema.addLayer(
      new Layer("segment", "Phones").setAlignment(Constants.ALIGNMENT_INTERVAL)
      .setPeers(true).setPeersOverlap(false).setSaturated(true)
      .setParentId(schema.getWordLayerId()).setParentIncludes(true));
    // schema.addLayer(
    //   new Layer("score", "Confidence").setAlignment(Constants.ALIGNMENT_NONE)
    //   .setPeers(false).setPeersOverlap(false).setSaturated(true)
    //   .setParentId("segment").setParentIncludes(true));
    return schema;
  } // end of getSchema()
  
  /**
   * Specifies which layers should be given to the serializer. The default implementaion
   * returns only the "utterance" layer.
   * @return An array of layer IDs.
   */
  public String[] getLayersToSerialize() {
    String[] layers = { "utterance", "word", "segment" };
    return layers;
  } // end of getLayersToSerialize()

  /**
   * Process the transcripts after they were deserialized, but before they're
   * serialized. 
   * @param transcripts
   */
  public void processTranscripts(Graph[] transcripts) {
    // construct utterance/turn annotations
    for (Graph transcript : transcripts) {
      transcript.commit();
      String label = Optional.ofNullable(speakerId)
        .orElse(transcript.getId().replaceAll("__[0-9]+\\.[0-9]+-[0-9]+\\.[0-9]+$",""));
      Annotation participant = transcript.createTag(
        transcript, transcript.getSchema().getParticipantLayerId(), label);
      Annotation turn = transcript.createTag(
        participant, transcript.getSchema().getTurnLayerId(), label);
      for (Annotation a : transcript.all(transcript.getSchema().getUtteranceLayerId())) {
        a.setParent(turn);
        a.setLabel(label);
      }
      for (Annotation a : transcript.all("word")) {
        a.setParent(turn);
      }
      if (removeHtkSegmentPrefix) {
        HTK2DISC htk2disc = new HTK2DISC();
        for (Annotation a : transcript.all("segment")) {
          a.setLabel(htk2disc.apply(a.getLabel()));
        }
      } // removeHtkSegmentPrefix
    }
  } // end of processTranscripts()
  
  private static final long serialVersionUID = -1;
} // end of class MlfToTextGrid
