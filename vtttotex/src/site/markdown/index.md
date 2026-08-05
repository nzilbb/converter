# VttToTex

Converts WebVTT subtitle files to LaTeX documents

The resulting .tex files each include a definition for a new '	urn' command which is used throughout the trancript to format speaker turns; this can be customized directly in the .tex files after conversion, or with the --texTurnCommand command line switch. e.g. "--texTurnCommand=\item[#1:] #2"
 (#1 = Speaker ID, #2 = Turn Text)

## Deserializing from "WebVTT subtitles" text/vtt

Command-line configuration parameters for deserialization:

|   |   |
|:--|:--|
| `--nonWordPattern=(\([0-9]+\.[0-9]+\))|([\p{Punct}&&[^_]])` | Regular expression to identify non-word characters for joining to a neighboring words e.g. (\([0-9]+\.[0-9]+\))|([\p{Punct}&&[^_]]) - set this blank to simply tokenize on spaces. |

## Serializing to "LaTeX Document" application/x-tex

Command-line configuration parameters for serialization:

|   |   |
|:--|:--|
| `--noiseLayer=`*Layer* | Background noises |
| `--orthographyLayer=`*Layer* | Orthography |
| `--texPreamble=` | TeX code to include in the preamble, e.g. "\usepackage{lineno, blindtext}" |
| `--texBeginTranscript=\begin{description}` | TeX to insert before the first turn, e.g. "\begin{description}" |
| `--texTurnCommand=\item[#1:] #2` | TeX command for formatting a speech turn, e.g. "\item[#1:] #2" - #1 = Speaker ID, #2 = Turn Text |
| `--texEndTranscript=\end{description}` | TeX to insert after the last turn, e.g. "\end{description}" |
