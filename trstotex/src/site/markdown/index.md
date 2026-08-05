# TrsToTex

Converts Transcriber .trs files to LaTeX documents

The resulting .tex files each include a definition for a new '	urn' command which is used throughout the trancript to format speaker turns; this can be customized directly in the .tex files after conversion, or with the --texTurnCommand command line switch. e.g. "--texTurnCommand=\item[#1:] #2"
 (#1 = Speaker ID, #2 = Turn Text)

## Deserializing from "Transcriber transcript" text/xml-transcriber

Command-line configuration parameters for deserialization:

|   |   |
|:--|:--|
| `--topicLayer=topic` | Topic tags |
| `--commentLayer=`*Layer* | Commentary |
| `--noiseLayer=noise` | Noise annotations |
| `--languageLayer=language` | Inline language tags |
| `--lexicalLayer=lexical` | Lexical tags |
| `--pronounceLayer=pronounce` | Manual pronunciation tags |
| `--entityLayer=entity` | Named entities |
| `--scribeLayer=transcript_scribe` | Name of transcriber |
| `--versionLayer=`*Layer* | Version of transcriber |
| `--versionDateLayer=`*Layer* | Version date of transcriber |
| `--programLayer=`*Layer* | Name of the program recorded |
| `--airDateLayer=transcript_recording_date` | Date the program aired |
| `--transcriptLanguageLayer=transcript_language` | The language of the whole transcript |
| `--participantCheckLayer=`*Layer* | Participant checked |
| `--genderLayer=`*Layer* | Gender - participant 'type' |
| `--dialectLayer=`*Layer* | Participant's dialect |
| `--accentLayer=`*Layer* | Participant's accent |
| `--scopeLayer=`*Layer* | Participant's 'scope' |

## Serializing to "LaTeX Document" application/x-tex

Command-line configuration parameters for serialization:

|   |   |
|:--|:--|
| `--noiseLayer=noise` | Background noises |
| `--orthographyLayer=`*Layer* | Orthography |
| `--texPreamble=` | TeX code to include in the preamble, e.g. "\usepackage{lineno, blindtext}" |
| `--texBeginTranscript=\begin{description}` | TeX to insert before the first turn, e.g. "\begin{description}" |
| `--texTurnCommand=\item[#1:] #2` | TeX command for formatting a speech turn, e.g. "\item[#1:] #2" - #1 = Speaker ID, #2 = Turn Text |
| `--texEndTranscript=\end{description}` | TeX to insert after the last turn, e.g. "\end{description}" |
