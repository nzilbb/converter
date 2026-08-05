# EafToTex

Converts ELAN .eaf files to LaTeX .tex files

All tiers will be interpreted as transcription of participant speech. If some tiers contain other annotations, use the --ignoreTiers command line switch to exclude them from the conversion using a regular expression, e.g.:
 --ignoreTiers=Noise|Topic
 

ELAN has no direct mechanism for marking non-speech annotations in their position within the transcript text. However, this converter can assume the use of textual conventions in various ways to make certain annotations: 
 - To tag a word with its pronunciation, enter the pronunciation in square brackets, directly following the word (i.e. with no intervening space), e.g.: 
 …this was at Wingatui[wIN@tui]…
 - To tag a word with its full orthography (if the transcript doesn't include it), enter the orthography in round parentheses, directly following the word (i.e. with no intervening space), e.g.: 
 …I can't remem~(remember)…
 - To insert a noise annotation within the text, enclose it in square brackets (surrounded by spaces so it's not taken as a pronunciation annotation), e.g.: 
 …sometimes me [laughs] not always but sometimes…
 - To insert a comment annotation within the text, enclose it in curly braces (surrounded by spaces), e.g.: 
 …beautifully warm {softly} but its…

To enable these transcription conventions, use the --useConventions command-line switch.
 

The resulting .tex files each include a definition for a new '	urn' command which is used throughout the trancript to format speaker turns; this can be customized directly in the .tex files after conversion, or with the --texTurnCommand command line switch.

e.g. "--texTurnCommand=\item[#1:] #2"
 (#1 = Speaker ID, #2 = Turn Text)

## Deserializing from "ELAN EAF Transcript" text/x-eaf+xml

Command-line configuration parameters for deserialization:

|   |   |
|:--|:--|
| `--commentLayer=comment` | Commentary |
| `--noiseLayer=noise` | Noise annotations |
| `--lexicalLayer=lexical` | Lexical tags |
| `--pronounceLayer=pronounce` | Manual pronunciation tags |
| `--authorLayer=`*Layer* | Name of transcriber |
| `--dateLayer=`*Layer* | Document date |
| `--languageLayer=transcript_language` | The language of the whole transcript |
| `--phraseLanguageLayer=`*Layer* | For tagging individual phrases with a language |
| `--useConventions=false` | Whether to use text conventions for comment, noise, lexical, and pronounce annotations |
| `--ignoreBlankAnnotations=true` | Whether to skip annotations with no label, or process them |
| `--minimumTurnPauseLength=0.0` | Minimum amount of time between two turns by the same speaker, with no intervening speaker, for which the inter-turn pause counts as a turn change boundary. If the pause is shorter than this, the turns are merged into one. |

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
