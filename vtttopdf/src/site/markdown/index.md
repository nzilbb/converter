# VttToPdf

Converts WebVTT subtitle files to PDF documents

## Deserializing from "WebVTT subtitles" text/vtt

Command-line configuration parameters for deserialization:

|   |   |
|:--|:--|
| `--nonWordPattern=(\([0-9]+\.[0-9]+\))|([\p{Punct}&&[^_]])` | Regular expression to identify non-word characters for joining to a neighboring words e.g. (\([0-9]+\.[0-9]+\))|([\p{Punct}&&[^_]]) - set this blank to simply tokenize on spaces. |

## Serializing to "PDF Document" application/pdf

Command-line configuration parameters for serialization:

|   |   |
|:--|:--|
| `--noiseLayer=`*Layer* | Background noises |
| `--orthographyLayer=`*Layer* | Orthography |
| `--mainParticipantLayer=`*Layer* | Main Participant |
| `--logoFile=`*String* | An image file for a head logo to insert at the beginning of the PDF |
| `--logoScalePercent=`*Integer* | Logo size, in percent of original size. |
