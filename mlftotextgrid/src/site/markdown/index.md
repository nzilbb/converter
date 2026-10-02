# MlfToTextGrid

Converts HTK .mlf files to Praat .TextGrid files

## Deserializing from "HTK Labels" text/x-htk+plain

Command-line configuration parameters for deserialization:

|   |   |
|:--|:--|
| `--noiseLayer=`*Layer* | Noise annotations |
| `--phoneLayer=segment` | Layer for aligned phones |
| `--wordLayer=word` | Layer for aligned words |
| `--scoreLayer=`*Layer* | Layer for HTK confidence score |
| `--useP2FACorrection=false` | Whether the P2FA 11,025Hz alignment correction should be applied |
| `--noiseIdentifiersString=` | Space-separated list of noise labels |

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
