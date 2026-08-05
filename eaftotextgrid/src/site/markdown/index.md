# EafToTextGrid

Converts ELAN .eaf files to Praat .TextGrid files

ELAN tiers are converted directly to Praat tiers as-is.

Tiers have the same names, unless the ELAN tier has the 'Participant' attribute set in which case, the resulting TextGrid tier will be named after the participant

## Deserializing from "ELAN EAF Transcript" text/x-eaf+xml

Command-line configuration parameters for deserialization:

|   |   |
|:--|:--|
| `--commentLayer=`*Layer* | Commentary |
| `--noiseLayer=`*Layer* | Noise annotations |
| `--lexicalLayer=`*Layer* | Lexical tags |
| `--pronounceLayer=`*Layer* | Manual pronunciation tags |
| `--authorLayer=`*Layer* | Name of transcriber |
| `--dateLayer=`*Layer* | Document date |
| `--languageLayer=`*Layer* | The language of the whole transcript |
| `--phraseLanguageLayer=`*Layer* | For tagging individual phrases with a language |
| `--useConventions=false` | Whether to use text conventions for comment, noise, lexical, and pronounce annotations |
| `--ignoreBlankAnnotations=true` | Whether to skip annotations with no label, or process them |
| `--minimumTurnPauseLength=0.0` | Minimum amount of time between two turns by the same speaker, with no intervening speaker, for which the inter-turn pause counts as a turn change boundary. If the pause is shorter than this, the turns are merged into one. |

## Serializing to "Praat TextGrid" text/praat-textgrid

Command-line configuration parameters for serialization:

|   |   |
|:--|:--|
| `--commentLayer=`*Layer* | Commentary |
| `--noiseLayer=`*Layer* | Noise annotations |
| `--lexicalLayer=`*Layer* | Lexical tags |
| `--pronounceLayer=`*Layer* | Manual pronunciation tags |
| `--renameParticipantsMatching=`*String* | A regular expression identifying participants that should be renamed using renameParticipantsTo - e.g. S([0-9]) |
| `--renameParticipantsTo=`*String* | A pattern specifying how participants identified by renameParticipantsTo should be renamed - may contain capturing group referencs like $1, or ${id}/${filename} for the filename without/with extension - e.g. ${id}-$1 |
| `--allowPeerOverlap=false` | Allows TextGrids with, for example, multiple segment tiers, if the underlying annotations are invalid and have overlapping segments. |
| `--utteranceThreshold=0.5` | Minimum inter-word pause to trigger an utterance boundary, when no utterance layer is mapped. 0 means 'do not infer utterance boundaries'. |
| `--useConventions=false` | Whether to use text conventions for comment, noise, lexical, and pronounce annotations |
| `--ignoreLabels=`*String* | Regular expression for annotation to ignore, e.g. <p:> to ignore MAUS pauses |
| `--includeMetaData=false` | Whether to include transcript attributes as one-annotation tiers or ignore them |
