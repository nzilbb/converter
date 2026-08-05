# EafToSlt

Converts ELAN .eaf files SALT .slt transcripts

ELAN doesn't natively support meta-data like Dob, Doe, Ethnicity, etc. however if this data is present in the .eaf HEADER in PROPERTY tags, named "metadata:Doe" etc. then they will be copied to the .slt header.

By default, inline SALT annotations (mazes, codes, bound morphemes, etc.) are not interpreted. If you want them to be processed, use --parseInlineConventions

All tiers will be interpreted as transcription of participant speech. If some tiers contain other annotations, use the --ignoreTiers command line switch to exclude them from the conversion using a regular expression, e.g.:
 --ignoreTiers=Noise|Topic

## Deserializing from "ELAN EAF Transcript" text/x-eaf+xml

Command-line configuration parameters for deserialization:

|   |   |
|:--|:--|
| `--commentLayer=comment` | Commentary |
| `--noiseLayer=`*Layer* | Noise annotations |
| `--lexicalLayer=`*Layer* | Lexical tags |
| `--pronounceLayer=`*Layer* | Manual pronunciation tags |
| `--authorLayer=`*Layer* | Name of transcriber |
| `--dateLayer=`*Layer* | Document date |
| `--languageLayer=Language` | The language of the whole transcript |
| `--phraseLanguageLayer=`*Layer* | For tagging individual phrases with a language |
| `--useConventions=false` | Whether to use text conventions for comment, noise, lexical, and pronounce annotations |
| `--ignoreBlankAnnotations=true` | Whether to skip annotations with no label, or process them |
| `--minimumTurnPauseLength=0.0` | Minimum amount of time between two turns by the same speaker, with no intervening speaker, for which the inter-turn pause counts as a turn change boundary. If the pause is shorter than this, the turns are merged into one. |

## Serializing to "SALT transcript" text/x-salt

Command-line configuration parameters for serialization:

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
| `--languageLayer=Language` | Layer for recording the language of the speech |
| `--participantIdLayer=ParticipantId` | Layer for recording the target participant's ID |
| `--genderLayer=Gender` | Layer for recording the gender of the target participant |
| `--dobLayer=Dob` | Layer for recording the birth date of the target participant |
| `--doeLayer=Doe` | Layer for recording the date the recording was elicited |
| `--caLayer=Ca` | Layer for recording the target participant's age when recorded |
| `--ethnicityLayer=Ethnicity` | Layer for recording the ethnicity of the target participant |
| `--contextLayer=Context` | Layer for recording the sampling context |
| `--subgroupLayer=Subgroup` | Layer for recording the sub-group/story |
| `--collectLayer=Collect` | Layer for recording the collection point of the elicitation |
| `--locationLayer=Location` | Layer for recording the location of the elicitation |
| `--dateFormat=d/M/yyyy` | Format used in SALT files for dates (e.g. Dob, Doe) - either M/d/yyyy or d/M/yyyy. NB: the default date format is inferred from your locale settings |
| `--parseInlineConventions=true` | Whether to use SALT in-line conventions when deserializing. If false, then only meta-data headers, comment lines, and time stamps are parsed; all in-line annotation conventions are left as-is |
