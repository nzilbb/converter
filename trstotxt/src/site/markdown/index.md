# TrsToText

Converts Transcriber .trs files to plain text files

The following participant meta-data is lost during conversion:
- gender
- dialect
- accent
- scope
 

If the --metaData command-line switch is used, then the following Transcriber meta-data will be included as a header to the file:
- version
- version date
- air date
- scribe
- language

Otherwise, this meta-data is lost during conversion
 

The following Transcriber annotations are lost during conversion:
- phrase language annotations
- named entity annotations
 

The following Transcriber annotations are converted using bracketed, inline text conventions:
- comments
- noises
- lexical tags
- pronounce tags

To disable these conventions (and thus lose these annotations during conversion) use the --useConventions=false command line switch.
 

If the --textOnly command-line switch is used, then the output text includes only the transcribed speech, and all annotations and meta-data are lost.

## Deserializing from "Transcriber transcript" text/xml-transcriber

Command-line configuration parameters for deserialization:

|   |   |
|:--|:--|
| `--topicLayer=`*Layer* | Topic tags |
| `--commentLayer=comment` | Commentary |
| `--noiseLayer=noise` | Noise annotations |
| `--languageLayer=`*Layer* | Inline language tags |
| `--lexicalLayer=`*Layer* | Lexical tags |
| `--pronounceLayer=`*Layer* | Manual pronunciation tags |
| `--entityLayer=`*Layer* | Named entities |
| `--scribeLayer=scribe` | Name of transcriber |
| `--versionLayer=version` | Version of transcriber |
| `--versionDateLayer=versiondate` | Version date of transcriber |
| `--programLayer=program` | Name of the program recorded |
| `--airDateLayer=airdate` | Date the program aired |
| `--transcriptLanguageLayer=language` | The language of the whole transcript |
| `--participantCheckLayer=`*Layer* | Participant checked |
| `--genderLayer=`*Layer* | Gender - participant 'type' |
| `--dialectLayer=`*Layer* | Participant's dialect |
| `--accentLayer=`*Layer* | Participant's accent |
| `--scopeLayer=`*Layer* | Participant's 'scope' |

## Serializing to "Plain Text Document" text/plain

Command-line configuration parameters for serialization:

|   |   |
|:--|:--|
| `--commentLayer=comment` | Commentary |
| `--noiseLayer=noise` | Background noises |
| `--lexicalLayer=`*Layer* | Lexical tags |
| `--pronounceLayer=`*Layer* | Non-standard pronunciation tags |
| `--orthographyLayer=`*Layer* | Orthography |
| `--useConventions=true` | Whether to use text conventions for comment, noise, lexical, and pronounce annotations |
| `--maxParticipantLength=20` | The maximum length of a participant name |
| `--maxHeaderLines=50` | The maximum number of lines in a meta-data header |
| `--participantFormat={0}: ` | Format for marking a change of turn within the transcript body - e.g. {0}:, where {0} is a place-holder for the participant ID/name |
| `--metaDataFormat={0}={1}` | Format for a meta-data line in the header - e.g. {0}={1}, where {0} is a place-holder for the attribute name or key, and {1} is a place-holder for the attribute value |
| `--tagFormat={0}_{1}` | Output format for tags - e.g. {0}_{1} for output like 'the_DET', where {0} is a place-holder for the word, and {1} is a place-holder for annotation label |
| `--includeMissingTags=false` | Whether to output missing tags with Tag Format, e.g. if the word 'the' has no tag, setting this to true will output 'the_', and false will output 'the'. |
| `--timestampFormat=HH:mm:ss.SSS` | Format for a time stamp - e.g. HH:mm:ss.SSS |
| `--nonWordPattern=(\([0-9]+\.[0-9]+\))|([\p{Punct}&&[^_]])` | Regular expression to identify non-word characters for joining to a neighboring words e.g. (\([0-9]+\.[0-9]+\))|([\p{Punct}&&[^_]]) - set this blank to simply tokenize on spaces. |
