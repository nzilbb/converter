# SltToTextGrid

Converts SALT .slt transcripts to Praat .TextGrid files

Praat doesn't support meta-data like Dob, Doe, Ethnicity, etc. so almost all SALT header meta-data is lost when converting to .eaf.

By default, inline annotations (mazes, codes, bound morphemes, etc.) are not interpreted and appear as-is in the TextGrid. If you want them to be parse (i.e. annotations removed to yield more standard orthography), use --parseInlineConventions

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
| `--parseInlineConventions=false` | Whether to use SALT in-line conventions when deserializing. If false, then only meta-data headers, comment lines, and time stamps are parsed; all in-line annotation conventions are left as-is |

## Serializing to "Praat TextGrid" text/praat-textgrid

Command-line configuration parameters for serialization:

|   |   |
|:--|:--|
| `--commentLayer=comment` | Commentary |
| `--noiseLayer=`*Layer* | Noise annotations |
| `--lexicalLayer=`*Layer* | Lexical tags |
| `--pronounceLayer=`*Layer* | Manual pronunciation tags |
| `--renameParticipantsMatching=`*String* | A regular expression identifying participants that should be renamed using renameParticipantsTo - e.g. S([0-9]) |
| `--renameParticipantsTo=`*String* | A pattern specifying how participants identified by renameParticipantsTo should be renamed - may contain capturing group referencs like $1, or ${id}/${filename} for the filename without/with extension - e.g. ${id}-$1 |
| `--allowPeerOverlap=false` | Allows TextGrids with, for example, multiple segment tiers, if the underlying annotations are invalid and have overlapping segments. |
| `--utteranceThreshold=0.5` | Minimum inter-word pause to trigger an utterance boundary, when no utterance layer is mapped. 0 means 'do not infer utterance boundaries'. |
| `--useConventions=false` | Whether to use text conventions for comment, noise, lexical, and pronounce annotations |
| `--ignoreLabels=`*String* | Regular expression for annotation to ignore, e.g. <p:> to ignore MAUS pauses |
| `--includeMetaData=false` | Whether to include transcript attributes as one-annotation tiers or ignore them |
