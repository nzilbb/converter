# TrsToVtt

Converts Transcriber .trs files to Web VTT subtitles

As WebVTT is a subtitle format, not related to a linguistic annotation tool, all annotations that Transcriber supports are lost during this conversion, including:
- topics
- comments
- noises
- phrase language annotations
- named entity annotations
- lexical tags
- pronounce tags
 

Although WebVTT does not support meta-data, the meta-data that is present in the Transcriber transcript is included in the .vtt file as NOTEs, including:
- version
- version date
- air date
- scribe
- language
- participant gender
- participant dialect
- participant accent
- participant scope

## Deserializing from "Transcriber transcript" text/xml-transcriber

Command-line configuration parameters for deserialization:

|   |   |
|:--|:--|
| `--topicLayer=topic` | Topic tags |
| `--commentLayer=comment` | Commentary |
| `--noiseLayer=noise` | Noise annotations |
| `--languageLayer=language` | Inline language tags |
| `--lexicalLayer=lexical` | Lexical tags |
| `--pronounceLayer=pronounce` | Manual pronunciation tags |
| `--entityLayer=entity` | Named entities |
| `--scribeLayer=transcript_scribe` | Name of transcriber |
| `--versionLayer=transcript_version` | Version of transcriber |
| `--versionDateLayer=transcript_version_date` | Version date of transcriber |
| `--programLayer=`*Layer* | Name of the program recorded |
| `--airDateLayer=transcript_air_date` | Date the program aired |
| `--transcriptLanguageLayer=transcript_language` | The language of the whole transcript |
| `--participantCheckLayer=`*Layer* | Participant checked |
| `--genderLayer=participant_gender` | Gender - participant 'type' |
| `--dialectLayer=participant_dialect` | Participant's dialect |
| `--accentLayer=participant_accent` | Participant's accent |
| `--scopeLayer=participant_scope` | Participant's 'scope' |

## Serializing to "WebVTT subtitles" text/vtt

Command-line configuration parameters for serialization:

|   |   |
|:--|:--|
| `--nonWordPattern=(\([0-9]+\.[0-9]+\))|([\p{Punct}&&[^_]])` | Regular expression to identify non-word characters for joining to a neighboring words e.g. (\([0-9]+\.[0-9]+\))|([\p{Punct}&&[^_]]) - set this blank to simply tokenize on spaces. |
