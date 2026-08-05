# ChaToTextGrid

Converts CLAN CHAT transcripts to Praat TextGrids

Praat doesn't support any meta-data like @Date, @Location, etc. so all CHAT header meta-data is lost when converting to .TextGrid.
 

This conversion will only work well for CHAT transcripts that are fully aligned; i.e. all lines include time alignment bullets.
 

The CLAN parser is *not exhaustive*; it one parses:
- Disfluency marking with &+ - e.g. `so &+sund Sunday`
- Non-standard form expansion - e.g. `gonna [: going to]`
- Incomplete word completion - e.g. `dinner doin(g) all`
- Acronym/proper name joining with _ - e.g. `no T_V in my room`
- Retracing - e.g. `<some friends and I> [//] uh` or `and sit [//] sets him`
- Repetition/stuttered false starts - e.g. `the <picnic> [/] picnic` or `the Saturday [/] in the morning`
- Errors - e.g. `they've <work up a hunger> [* s:r]` or `they got [* m] to`

## Deserializing from "CLAN CHAT transcript" text/x-chat

Command-line configuration parameters for deserialization:

|   |   |
|:--|:--|
| `--cUnitLayer=cunit` | Layer for marking c-units |
| `--tokenLayer=word` | Output word tokens come from this layer |
| `--disfluencyLayer=`*Layer* | Layer for disfluency annotations |
| `--nonWordLayer=noise` | Layer for non-word noises |
| `--expansionLayer=expansion` | Layer for expansion annotations |
| `--errorsLayer=error` | Layer for error  annotations |
| `--linkageLayer=linkage` | Layer for linkage annotations |
| `--repetitionsLayer=repetition` | Layer for repetition annotations |
| `--retracingLayer=retracing` | Layer for retracing annotations |
| `--pauseLayer=`*Layer* | Layer for marking unfilled pauses |
| `--completionLayer=`*Layer* | Layer for completion annotations |
| `--morLayer=`*Layer* | Layer for morphosyntactic tags |
| `--morPrefixLayer=`*Layer* | Layer for prefixes in MOR tags |
| `--morPartOfSpeechLayer=`*Layer* | Layer for parts of speech in MOR tags |
| `--morPartOfSpeechSubcategoryLayer=`*Layer* | Layer for subcategories of parts of speech in MOR tags |
| `--morStemLayer=`*Layer* | Layer for stems in MOR tags |
| `--morFusionalSuffixLayer=`*Layer* | Layer for fusional suffixes in MOR tags |
| `--morSuffixLayer=`*Layer* | Layer for (non-fusional) suffixes in MOR tags |
| `--morGlossLayer=`*Layer* | Layer for English glosses in MOR tags |
| `--graLayer=`*Layer* | Layer for grammatical dependency tags |
| `--gemLayer=topic` | Layer for gems |
| `--transcriberLayer=transcript_scribe` | Layer for transcriber name |
| `--languagesLayer=transcript_language` | Layer for transcriber language |
| `--dateLayer=`*Layer* | Layer for date of the interaction |
| `--locationLayer=`*Layer* | Layer for location of the interaction |
| `--recordingQualityLayer=`*Layer* | Layer for recording quality |
| `--roomLayoutLayer=`*Layer* | Layer for room layout |
| `--tapeLocationLayer=`*Layer* | Layer for tape and location on the tape covered by the transcription |
| `--targetParticipantLayer=main_participant` | Layer for identifying target participants |
| `--SESLayer=participant_ses` | Layer for SES |
| `--roleLayer=participant_role` | Layer for role |
| `--educationLayer=participant_education` | Layer for education |
| `--sexLayer=participant_gender` | Layer for sex |
| `--customLayer=`*Layer* | Layer for custom |
| `--corpusLayer=participant_corpus` | Layer for corpus |
| `--languageLayer=participant_language` | Layer for language |
| `--ageLayer=participant_age` | Layer for age |
| `--groupLayer=participant_group` | Layer for group |
| `--includeTimeCodes=true` | Include utterance sychronization information when exporting transcripts |
| `--splitMorTagGroups=true` | Split alternative MOR taggings into separate annotations |
| `--splitMorWordGroups=true` | Split MOR word morphemes (clitics, components of compounds ) into separate annotations. This is only supported when Split MOR Tag Groups is also enabled. |

## Serializing to "Praat TextGrid" text/praat-textgrid

Command-line configuration parameters for serialization:

|   |   |
|:--|:--|
| `--commentLayer=comment` | Commentary |
| `--noiseLayer=noise` | Noise annotations |
| `--lexicalLayer=`*Layer* | Lexical tags |
| `--pronounceLayer=`*Layer* | Manual pronunciation tags |
| `--renameParticipantsMatching=`*String* | A regular expression identifying participants that should be renamed using renameParticipantsTo - e.g. S([0-9]) |
| `--renameParticipantsTo=`*String* | A pattern specifying how participants identified by renameParticipantsTo should be renamed - may contain capturing group referencs like $1, or ${id}/${filename} for the filename without/with extension - e.g. ${id}-$1 |
| `--allowPeerOverlap=false` | Allows TextGrids with, for example, multiple segment tiers, if the underlying annotations are invalid and have overlapping segments. |
| `--utteranceThreshold=0.5` | Minimum inter-word pause to trigger an utterance boundary, when no utterance layer is mapped. 0 means 'do not infer utterance boundaries'. |
| `--useConventions=false` | Whether to use text conventions for comment, noise, lexical, and pronounce annotations |
| `--ignoreLabels=`*String* | Regular expression for annotation to ignore, e.g. <p:> to ignore MAUS pauses |
| `--includeMetaData=false` | Whether to include transcript attributes as one-annotation tiers or ignore them |
