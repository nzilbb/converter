# TrsToEaf

Converts Transcriber .trs transcripts to ELAN .eaf files

ELAN does not support the same meta-data that Transcriber does, so the following meta-data is lost during conversion:
- version
- version date
- air date
- scribe
- language
- participant gender
- participant dialect
- participant accent
- participant scope

The following Transcriber annotations are not supported by ELAN, and are lost:
- phrase language annotations
- named entity annotations

The following Transcriber annotations are not directly supported by ELAN, and are converted using bracketed, inline conventions within annotation labels:
- comments
- noises
- lexical tags
- pronounce tags

To disable these conventions (and thus lose these annotations during conversion) use the --useConventions=false command line switch.

If the Transcriber transcript includes topic tags, these are included in the ELAN file on their own tier.

## Deserializing from "Transcriber transcript" text/xml-transcriber

Command-line configuration parameters for deserialization:

|   |   |
|:--|:--|
| `--topicLayer=topic` | Topic tags |
| `--commentLayer=comment` | Commentary |
| `--noiseLayer=noise` | Noise annotations |
| `--languageLayer=language` | Inline language tags |
| `--lexicalLayer=lexical` | Lexical tags |
| `--pronounceLayer=pronounce` | Manual pronunciation tags |
| `--entityLayer=entity` | Named entities |
| `--scribeLayer=transcript_scribe` | Name of transcriber |
| `--versionLayer=transcript_version` | Version of transcriber |
| `--versionDateLayer=transcript_version_date` | Version date of transcriber |
| `--programLayer=`*Layer* | Name of the program recorded |
| `--airDateLayer=transcript_air_date` | Date the program aired |
| `--transcriptLanguageLayer=transcript_language` | The language of the whole transcript |
| `--participantCheckLayer=`*Layer* | Participant checked |
| `--genderLayer=participant_gender` | Gender - participant 'type' |
| `--dialectLayer=participant_dialect` | Participant's dialect |
| `--accentLayer=participant_accent` | Participant's accent |
| `--scopeLayer=participant_scope` | Participant's 'scope' |

## Serializing to "ELAN EAF Transcript" text/x-eaf+xml

Command-line configuration parameters for serialization:

|   |   |
|:--|:--|
| `--commentLayer=comment` | Commentary |
| `--noiseLayer=noise` | Noise annotations |
| `--lexicalLayer=lexical` | Lexical tags |
| `--pronounceLayer=pronounce` | Manual pronunciation tags |
| `--authorLayer=transcript_scribe` | Name of transcriber |
| `--dateLayer=transcript_version_date` | Document date |
| `--languageLayer=transcript_language` | The language of the whole transcript |
| `--phraseLanguageLayer=language` | For tagging individual phrases with a language |
| `--useConventions=true` | Whether to use text conventions for comment, noise, lexical, and pronounce annotations |
| `--ignoreBlankAnnotations=true` | Whether to skip annotations with no label, or process them |
| `--minimumTurnPauseLength=0.0` | Minimum amount of time between two turns by the same speaker, with no intervening speaker, for which the inter-turn pause counts as a turn change boundary. If the pause is shorter than this, the turns are merged into one. |
