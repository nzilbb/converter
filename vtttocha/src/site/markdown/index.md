# VttToCha

Converts WebVTT subtitle files to CLAN CHAT transcripts

## Deserializing from "WebVTT subtitles" text/vtt

Command-line configuration parameters for deserialization:

|   |   |
|:--|:--|
| `--nonWordPattern=(\([0-9]+\.[0-9]+\))|([\p{Punct}&&[^_]])` | Regular expression to identify non-word characters for joining to a neighboring words e.g. (\([0-9]+\.[0-9]+\))|([\p{Punct}&&[^_]]) - set this blank to simply tokenize on spaces. |

## Serializing to "CLAN CHAT transcript" text/x-chat

Command-line configuration parameters for serialization:

|   |   |
|:--|:--|
| `--cUnitLayer=`*Layer* | Layer for marking c-units |
| `--tokenLayer=word` | Output word tokens come from this layer |
| `--disfluencyLayer=`*Layer* | Layer for disfluency annotations |
| `--nonWordLayer=`*Layer* | Layer for non-word noises |
| `--expansionLayer=`*Layer* | Layer for expansion annotations |
| `--errorsLayer=`*Layer* | Layer for error  annotations |
| `--linkageLayer=`*Layer* | Layer for linkage annotations |
| `--repetitionsLayer=`*Layer* | Layer for repetition annotations |
| `--retracingLayer=`*Layer* | Layer for retracing annotations |
| `--pauseLayer=`*Layer* | Layer for marking unfilled pauses |
| `--completionLayer=`*Layer* | Layer for completion annotations |
| `--morLayer=`*Layer* | Layer for morphosyntactic tags |
| `--morPrefixLayer=`*Layer* | Layer for prefixes in MOR tags |
| `--morPartOfSpeechLayer=`*Layer* | Layer for parts of speech in MOR tags |
| `--morPartOfSpeechSubcategoryLayer=`*Layer* | Layer for subcategories of parts of speech in MOR tags |
| `--morStemLayer=`*Layer* | Layer for stems in MOR tags |
| `--morFusionalSuffixLayer=`*Layer* | Layer for fusional suffixes in MOR tags |
| `--morSuffixLayer=`*Layer* | Layer for (non-fusional) suffixes in MOR tags |
| `--morGlossLayer=`*Layer* | Layer for English glosses in MOR tags |
| `--gemLayer=`*Layer* | Layer for gems |
| `--transcriberLayer=`*Layer* | Layer for transcriber name |
| `--languagesLayer=`*Layer* | Layer for transcriber language |
| `--dateLayer=`*Layer* | Layer for date of the interaction |
| `--locationLayer=`*Layer* | Layer for location of the interaction |
| `--recordingQualityLayer=`*Layer* | Layer for recording quality |
| `--roomLayoutLayer=`*Layer* | Layer for room layout |
| `--tapeLocationLayer=`*Layer* | Layer for tape and location on the tape covered by the transcription |
| `--targetParticipantLayer=`*Layer* | Layer for identifying target participants |
| `--SESLayer=`*Layer* | Layer for SES |
| `--roleLayer=`*Layer* | Layer for role |
| `--educationLayer=`*Layer* | Layer for education |
| `--sexLayer=`*Layer* | Layer for sex |
| `--customLayer=`*Layer* | Layer for custom |
| `--corpusLayer=`*Layer* | Layer for corpus |
| `--languageLayer=`*Layer* | Layer for language |
| `--ageLayer=`*Layer* | Layer for age |
| `--groupLayer=`*Layer* | Layer for group |
| `--includeTimeCodes=true` | Include utterance sychronization information when exporting transcripts |
| `--splitMorTagGroups=true` | Split alternative MOR taggings into separate annotations |
| `--splitMorWordGroups=true` | Split MOR word morphemes (clitics, components of compounds ) into separate annotations. This is only supported when Split MOR Tag Groups is also enabled. |
