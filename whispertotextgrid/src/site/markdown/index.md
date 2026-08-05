# WhisperToTextGrid

Converts JSON-formatted Whisper ASR files to Praat TextGrids

## Deserializing from "Whisper ASR transcript" text/whisper+plain

Command-line configuration parameters for deserialization:

|   |   |
|:--|:--|
| `--languageLayer=`*Layer* | The language of the whole transcript |
| `--minShortPauseLength=0.35` | The minimum inter-word pause length, in seconds, before a pause counts as a 'short pause'. |
| `--shortPauseLabel=(.)` | If an inter-word pause has a duration between minShortPauseLength and minMediumPauseLength, then the word before the pause will have this string appended to its label (after a space). |
| `--minMediumPauseLength=0.7` | The minimum inter-word pause length, in seconds, before a pause counts as a 'medium pause' |
| `--mediumPauseLabel=(..)` | If an inter-word pause has a duration between minMediumPauseLength and minLongPauseLength, then the word before the pause will have this string appended to its label (after a space) |
| `--minLongPauseLength=1.4` | The minimum inter-word pause length, in seconds, before a pause counts as a 'long pause'. |
| `--longPauseLabel=(...)` | If an inter-word pause has a duration more than minLongPauseLength, then the word before the pause will have this string appended to its label (after a space) e.g. for the the length of the pause in parentheses, use: ({0.000}) |
| `--maxUtteranceDuration=15.0` | Utterances longer than this will be split on longer inter-word pauses, where possible. |
| `--utterancePadding=0.5` | Maximum number of seconds to subtract from the start time and add to the end time of each utterance, to allow for alignment errors of first/last word in each segment. |
| `--disfluencyFormat=$1~` | False starts like "w..." can be transformed to "w~" or "&+w" by specifying a format like "$1~" or "&+$1", or no pattern to not transform them. |

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
