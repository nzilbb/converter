# TrsToPdf

Converts Transcriber .trs files to PDFs

As PDF is not related to a linguistic annotation tool, all annotations that Transcriber supports are lost during this conversion, including:
- topics
- comments
- noises
- phrase language annotations
- named entity annotations
- lexical tags
- pronounce tags
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

## Serializing to "PDF Document" application/pdf

Command-line configuration parameters for serialization:

|   |   |
|:--|:--|
| `--noiseLayer=noise` | Background noises |
| `--orthographyLayer=`*Layer* | Orthography |
| `--mainParticipantLayer=`*Layer* | Main Participant |
| `--logoFile=`*String* | An image file for a head logo to insert at the beginning of the PDF |
| `--logoScalePercent=`*Integer* | Logo size, in percent of original size. |
