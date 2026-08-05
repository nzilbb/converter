# ChaToEaf

Converts CLAN CHAT transcripts to ELAN .eaf files

ELAN doesn't support meta-data like @Date, @Location, etc. so almost all CHAT header meta-data is lost when converting to .eaf.
 

This conversion will only work well for CHAT transcripts that are fully aligned; i.e. all lines include time alignment bullets.
 

The CLAN parser is *not exhaustive*; it one parses:
- Disfluency marking with &+ - e.g. `so &+sund Sunday`
- Non-standard form expansion - e.g. `gonna [: going to]`
- Incomplete word completion - e.g. `dinner doin(g) all`
- Acronym/proper name joining with _ - e.g. `no T_V in my room`
- Retracing - e.g. `<some friends and I> [//] uh` or `and sit [//] sets him`
- Repetition/stuttered false starts - e.g. `the <picnic> [/] picnic` or `the Saturday [/] in the morning`
- Errors - e.g. `they've <work up a hunger> [* s:r]` or `they got [* m] to`

## Deserializing from "CLAN CHAT transcript" text/x-chat

Command-line configuration parameters for deserialization:

|   |   |
|:--|:--|
| `--cUnitLayer=cunit` | Layer for marking c-units |
| `--tokenLayer=word` | Output word tokens come from this layer |
| `--disfluencyLayer=`*Layer* | Layer for disfluency annotations |
| `--nonWordLayer=noise` | Layer for non-word noises |
| `--expansionLayer=expansion` | Layer for expansion annotations |
| `--errorsLayer=error` | Layer for error  annotations |
| `--linkageLayer=linkage` | Layer for linkage annotations |
| `--repetitionsLayer=repetition` | Layer for repetition annotations |
| `--retracingLayer=retracing` | Layer for retracing annotations |
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
| `--graLayer=`*Layer* | Layer for grammatical dependency tags |
| `--gemLayer=topic` | Layer for gems |
| `--transcriberLayer=transcript_scribe` | Layer for transcriber name |
| `--languagesLayer=transcript_language` | Layer for transcriber language |
| `--dateLayer=`*Layer* | Layer for date of the interaction |
| `--locationLayer=`*Layer* | Layer for location of the interaction |
| `--recordingQualityLayer=`*Layer* | Layer for recording quality |
| `--roomLayoutLayer=`*Layer* | Layer for room layout |
| `--tapeLocationLayer=`*Layer* | Layer for tape and location on the tape covered by the transcription |
| `--targetParticipantLayer=main_participant` | Layer for identifying target participants |
| `--SESLayer=participant_ses` | Layer for SES |
| `--roleLayer=participant_role` | Layer for role |
| `--educationLayer=participant_education` | Layer for education |
| `--sexLayer=participant_gender` | Layer for sex |
| `--customLayer=`*Layer* | Layer for custom |
| `--corpusLayer=participant_corpus` | Layer for corpus |
| `--languageLayer=participant_language` | Layer for language |
| `--ageLayer=participant_age` | Layer for age |
| `--groupLayer=participant_group` | Layer for group |
| `--includeTimeCodes=true` | Include utterance sychronization information when exporting transcripts |
| `--splitMorTagGroups=true` | Split alternative MOR taggings into separate annotations |
| `--splitMorWordGroups=true` | Split MOR word morphemes (clitics, components of compounds ) into separate annotations. This is only supported when Split MOR Tag Groups is also enabled. |

## Serializing to "ELAN EAF Transcript" text/x-eaf+xml

Command-line configuration parameters for serialization:

|   |   |
|:--|:--|
| `--commentLayer=comment` | Commentary |
| `--noiseLayer=noise` | Noise annotations |
| `--lexicalLayer=`*Layer* | Lexical tags |
| `--pronounceLayer=`*Layer* | Manual pronunciation tags |
| `--authorLayer=transcript_scribe` | Name of transcriber |
| `--dateLayer=`*Layer* | Document date |
| `--languageLayer=transcript_language` | The language of the whole transcript |
| `--phraseLanguageLayer=`*Layer* | For tagging individual phrases with a language |
| `--useConventions=true` | Whether to use text conventions for comment, noise, lexical, and pronounce annotations |
| `--ignoreBlankAnnotations=true` | Whether to skip annotations with no label, or process them |
| `--minimumTurnPauseLength=0.0` | Minimum amount of time between two turns by the same speaker, with no intervening speaker, for which the inter-turn pause counts as a turn change boundary. If the pause is shorter than this, the turns are merged into one. |
