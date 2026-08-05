# SltToTrs

Converts SALT .slt transcripts to Transcriber .trs files

The SALT 'Context' header becomes the Transcriber 'Program'.

The SALT 'Subgroup' header becomes the Transcriber 'Topic'.

SALT meta-data that is not supported by Transcriber is added in comments at the beginning of the transcript.

By default, inline annotations (mazes, codes, bound morphemes, etc.) are not iterpreted. If you want them to be processed, use --parseInlineConventions

By default certain SALT word codes are converted into Transcriber 'pronounce' or 'lexical' events - i.e. those of the form "[PRONOUNCE:...]" and "[LEXICAL:...]" respectively.

Also certain SALT comments are converted into Transcriber 'noise' events - i.e. those of the form "{NOISE:...}". Use the command-line switches --pronounceCodePattern, --lexicalCodePattern, and --noiseCommentPattern to control this behaviour.

e.g. if you specify --pronounceCodePattern=WP:{0} then all word codes like [WP:...] will be pronounce events in the Transcriber transcript.

Similarly if you specify --pronounceCodePattern=WL:{0} then all word codes like [WL:...] will be lexical events in the Transcriber transcript.

Similarly if you specify --noiseCommentPattern=BG:{0} then all comments like [BG:...] will be noise events in the Transcriber transcript.

To disable these conversions, use "--pronounceCodePattern= --lexicalCodePattern= --noiseCommentPattern=" on the command line.

The format for dates is taken from your system settings; to override this, use the --dateFormat command line setting.

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
| `--soundEffectLayer=sound_effects` | Layer for marking non-word verbal sound effects |
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
| `--doeLayer=transcript_recording_date` | Layer for recording the date the recording was elicited |
| `--caLayer=transcript_ca` | Layer for recording the target participant's age when recorded |
| `--ethnicityLayer=participant_ethnicity` | Layer for recording the ethnicity of the target participant |
| `--contextLayer=transcript_context` | Layer for recording the sampling context |
| `--subgroupLayer=transcript_subgroup` | Layer for recording the sub-group/story |
| `--collectLayer=transcript_collect` | Layer for recording the collection point of the elicitation |
| `--locationLayer=transcript_location` | Layer for recording the location of the elicitation |
| `--dateFormat=d/M/yyyy` | Format used in SALT files for dates (e.g. Dob, Doe) - either M/d/yyyy or d/M/yyyy. NB: the default date format is inferred from your locale settings |
| `--parseInlineConventions=false` | Whether to use SALT in-line conventions when deserializing. If false, then only meta-data headers, comment lines, and time stamps are parsed; all in-line annotation conventions are left as-is |

## Serializing to "Transcriber transcript" text/xml-transcriber

Command-line configuration parameters for serialization:

|   |   |
|:--|:--|
| `--topicLayer=transcript_subgroup` | Topic tags |
| `--commentLayer=comment` | Commentary |
| `--noiseLayer=noise` | Noise annotations |
| `--languageLayer=`*Layer* | Inline language tags |
| `--lexicalLayer=lexical` | Lexical tags |
| `--pronounceLayer=pronounce` | Manual pronunciation tags |
| `--entityLayer=entity` | Named entities |
| `--scribeLayer=`*Layer* | Name of transcriber |
| `--versionLayer=`*Layer* | Version of transcriber |
| `--versionDateLayer=`*Layer* | Version date of transcriber |
| `--programLayer=transcript_context` | Name of the program recorded |
| `--airDateLayer=transcript_recording_date` | Date the program aired |
| `--transcriptLanguageLayer=transcript_language` | The language of the whole transcript |
| `--participantCheckLayer=`*Layer* | Participant checked |
| `--genderLayer=participant_gender` | Gender - participant 'type' |
| `--dialectLayer=`*Layer* | Participant's dialect |
| `--accentLayer=`*Layer* | Participant's accent |
| `--scopeLayer=`*Layer* | Participant's 'scope' |
