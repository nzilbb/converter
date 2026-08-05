# SltToTex

Converts SALT transcripts to LaTeX documents

Almost all SALT header meta-data is lost when converting to .tex.

By default, inline annotations (mazes, codes, bound morphemes, etc.) are parsed (and thus removed). If you want them to be included in the output as-is, use the --parseInlineConventions=false command line switch.
 

The resulting .tex files each include a definition for a new '	urn' command which is used throughout the trancript to format speaker turns; this can be customized directly in the .tex files after conversion, or with the --texTurnCommand command line switch. e.g. "--texTurnCommand=\item[#1:] #2"
 (#1 = Speaker ID, #2 = Turn Text)

## Deserializing from "SALT transcript" text/x-salt

Command-line configuration parameters for deserialization:

|   |   |
|:--|:--|
| `--cUnitLayer=cunit` | Layer for marking c-units |
| `--targetParticipantLayer=main_participant` | Layer for marking the target participant |
| `--commentLayer=comment` | Layer for comments |
| `--parentheticalLayer=parenthetical` | Layer for marking parenthetical remarks by the speaker |
| `--properNameLayer=entity` | Layer for tagging proper names |
| `--repetitionsLayer=repetition` | Layer for annotating repetitions |
| `--rootLayer=root` | Layer for tagging words with their root form |
| `--errorLayer=error` | Layer for marking errors |
| `--soundEffectLayer=noise` | Layer for marking non-word verbal sound effects |
| `--pauseLayer=pause` | Layer for marking pauses in speech |
| `--boundMorphemeLayer=bound_morpheme` | Layer for marking bound morpheme annotations |
| `--mazeLayer=maze` | Layer for marking false starts, repetitions, and reformulations |
| `--partialWordLayer=partial_word` | Layer for marking stuttered or interrupted words |
| `--omissionLayer=omission` | Layer for marking missing words |
| `--codeLayer=code` | Layer for non-error codes |
| `--languageLayer=transcript_language` | Layer for recording the language of the speech |
| `--participantIdLayer=participant_id` | Layer for recording the target participant's ID |
| `--genderLayer=participant_gender` | Layer for recording the gender of the target participant |
| `--dobLayer=participant_dob` | Layer for recording the birth date of the target participant |
| `--doeLayer=transcript_doe` | Layer for recording the date the recording was elicited |
| `--caLayer=transcript_ca` | Layer for recording the target participant's age when recorded |
| `--ethnicityLayer=participant_ethnicity` | Layer for recording the ethnicity of the target participant |
| `--contextLayer=transcript_context` | Layer for recording the sampling context |
| `--subgroupLayer=transcript_subgroup` | Layer for recording the sub-group/story |
| `--collectLayer=transcript_collect` | Layer for recording the collection point of the elicitation |
| `--locationLayer=transcript_location` | Layer for recording the location of the elicitation |
| `--dateFormat=d/M/yyyy` | Format used in SALT files for dates (e.g. Dob, Doe) - either M/d/yyyy or d/M/yyyy. NB: the default date format is inferred from your locale settings |
| `--parseInlineConventions=true` | Whether to use SALT in-line conventions when deserializing. If false, then only meta-data headers, comment lines, and time stamps are parsed; all in-line annotation conventions are left as-is |

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
