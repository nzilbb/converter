# Converters

[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.21501429.svg)](https://doi.org/10.5281/zenodo.21501429)

These are standalone programs that convert transcripts from one tool format to another, e.g.

* trs - [Transcriber](http://trans.sourceforge.net/en/presentation.php) transcripts
* eaf - [ELAN](https://archive.mpi.nl/tla/elan) files
* vtt - [web subtitles (Web VTT)](https://en.wikipedia.org/wiki/WebVTT)
* slt - [SALT](https://www.saltsoftware.com/) transcripts
* cha - [CLAN](https://dali.talkbank.org/clan/) CHAT transcripts
* textgrid - [Praat](https://praat.org) TextGrids
* pdf - *PDF* files
* tex - *LaTeX* files
* txt - *plain text* files
* kaldi - input files for the [Kaldi](https://kaldi-asr.org/) automatic speech recognition training system
* whisper - output .json files from the [Whisper](https://openai.com/index/whisper/) automatic speech recognition system (and its derivatives)

| to↓ from→ | trs | eaf  | vtt | slt | cha | textgrid | txt | whisper |
| --- | :---: | :---:  | :---: | :---: | :---: | :---: | :---: | :---: |
| **trs** | | [eaf-to-trs](eaf-to-trs/index.html) | [vtt-to-trs](vtt-to-trs/index.html) | [slt-to-trs](slt-to-trs/index.html) | [cha-to-trs](cha-to-trs/index.html) | [textgrid-to-trs](textgrid-to-trs/index.html) | | |
| **eaf** | [trs-to-eaf](trs-to-eaf/index.html) | | [vtt-to-eaf](vtt-to-eaf/index.html) | [slt-to-eaf](slt-to-eaf/index.html) | [cha-to-eaf](cha-to-eaf/index.html) | [textgrid-to-eaf](textgrid-to-eaf/index.html) | [txt-to-eaf](txt-to-eaf/index.html) | [whisper-to-eaf](whisper-to-eaf/index.html) |
| **vtt** | [trs-to-vtt](trs-to-vtt/index.html) | [eaf-to-vtt](eaf-to-vtt/index.html) | | [slt-to-vtt](slt-to-vtt/index.html) | [cha-to-vtt](cha-to-vtt/index.html) | [textgrid-to-vtt](textgrid-to-vtt/index.html) | | [whisper-to-vtt](whisper-to-vtt/index.html) |
| **slt** | [trs-to-slt](trs-to-slt/index.html) | [eaf-to-slt](eaf-to-slt/index.html) | | | | | | |
| **cha** | [trs-to-cha](trs-to-cha/index.html) | [eaf-to-cha](eaf-to-cha/index.html) | [vtt-to-cha](vtt-to-cha/index.html) | | | | | |
| **textgrid** | [trs-to-textgrid](trs-to-textgrid/index.html) | [eaf-to-textgrid](eaf-to-textgrid/index.html) | [vtt-to-textgrid](vtt-to-textgrid/index.html) | [slt-to-textgrid](slt-to-textgrid/index.html) | [cha-to-textgrid](cha-to-textgrid/index.html) | | | [whisper-to-textgrid](whisper-to-textgrid/index.html) |
| **txt** | [trs-to-txt](trs-to-txt/index.html) | | | | | | | |
| **pdf** | [trs-to-pdf](trs-to-pdf/index.html) | [eaf-to-pdf](eaf-to-pdf/index.html) | [vtt-to-pdf](vtt-to-pdf/index.html) | [slt-to-pdf](slt-to-pdf/index.html) | [cha-to-pdf](cha-to-pdf/index.html) | [textgrid-to-pdf](textgrid-to-pdf/index.html) | | |
| **tex** | [trs-to-tex](trs-to-tex/index.html) | [eaf-to-tex](eaf-to-tex/index.html) | [vtt-to-tex](vtt-to-tex/index.html) | [slt-to-tex](slt-to-tex/index.html) | | [textgrid-to-tex](textgrid-to-tex/index.html) | | |
| **kaldi** | [trs-to-kaldi](trs-to-kaldi/index.html) | [eaf-to-kaldi](eaf-to-kaldi/index.html) | | | | [textgrid-to-kaldi](textgrid-to-kaldi/index.html) | | |

To use a particular converter, you need to have Java installed on your
system. Download the file, and double-click it to run.

If double-clicking doesn't work, you can run the converter from the
command line, by entering:

```
java -jar vtt-to-textgrid.jar
```

By default converters display a window on to which you can drag and drop files for
converting. However, they can also be run in 'batch mode', which allows you to
automatically convert a list of files from the command line - e.g.

```
java -jar trs-to-textgrid.jar --batchmode *.trs
```

Some conversions have configurable output, e.g.

```
java -jar trs-to-txt.jar *.trs
```

...will include annotations and participant names in the output text files, but:

```
java -jar trs-to-txt.jar --textonly *.trs
```

...produces text files that exclude all annotations and participant names.

The `--usage` command-line switch prints information about command-line options.

As many formats do not support the meta-data, annotation granularity or ontology of other
formats, many of these conversions necessarily entail loss of data. However, mappings are
made from one format to another wherever possible.

For notes about specific correspondences or data losses, use the `--help` command-line
switch, or use the *Help|Information* menu option of the conversion utility concerned.

---

These use annotator serializers/deserializers
to read a file in one format, convert it to an annotation graph, and then write that graph
out as a file in another format. As pointed out by
Cochran et al. (2007 - *Report from TILR Working Group 1 : Tools interoperability and input/output formats*)
this saves having order *n<sup>2</sup>* explicit conversion algorithms between formats;
only *2n* format conversions are required
(as some of these formats above are output-only, it's actually less than *2n*).

This exemplifies an approach to linguistic data interoperability called the *interlingua
philosophy on interoperability* by
[Witt et al. (2009)](https://www.w3.org/People/fsasaki/docs/lre-intro.pdf)
and uses annotation graphs as an 'interlingua' similar to work by 
[Schmidt et al. (2008)](https://ids-pub.bsz-bw.de/frontdoor/deliver/index/docId/2308/file/Schmidt%20etc_An_exchange_format_for_multimodal_annotations_2008.pdf),
except that rather using a third file format as a persistent intermediary, the annotation
graph models of the linguistic data are ephemeral, existing in memory only for the duration of the
conversion.

## Getting TextGrid Transcripts of YouTube Videos

The basic process of making a YouTube video corpus with TextGrid transcripts is:

1. Download Youtube videos with their closed-caption subtitle files.
2. Convert the closed-caption subtitle files to TextGrids.

### 1. Download Youtube videos with subtitles

There's a tool called [yt-dlp](https://github.com/yt-dlp/yt-dlp) which can be used for
downloading videos from YouTube. It's a command-line program that can be given a URL for
downloading. If the URL is a playlist, then it will download all videos in the playlist into
separate files.

It has many useful command-line options:

* `--help` - Displays information about all the other command-line options.
*  `-f` - Sets the format for the video, e.g. `-f wav` should download WAV files,
  `mp4` will download MP4's, etc.
* `--extract-audio` - Extracts the audio from the video after downloading it. This
  option is useful if `-f wav` doesn't work because WAV is not available.
* `--audio-format` - Specifies what format to use if you're using `--extract-audio`
* `--sub-lang` - Downloads subtitle/closed-caption files for the given ISO language
  code. e.g. `--sub-lang en-GB` will download British English subtitles.  The subtitle files
  are saved in ...vtt files.

So for example the following command will download MP4 files and English closed-captions
for the given playlist:  
```
yt-dlp -f mp4 --sub-lang en https://www.youtube.com/playlist?list=PLdsZeeCVYnY3em55M2d3Iq3H-jSPLIWBF
```

...and the following will download WAV files instead of MP4 for the given playlist:  
```
yt-dlp  --extract-audio --audio-format wav --sub-lang en https://www.youtube.com/playlist?list=PLdsZeeCVYnY3em55M2d3Iq3H-jSPLIWBF
```

**Caveat:** There's a potential problem with using YouTube's automatically-generated captions;
they often have a whole bunch of repeated phrases as it goes through the recording, so much of
the resulting transcript is doubled up. So make sure you eyeball your TextGrids at the end to
ensure the results are what you expect!


### 2. Convert subtitles to Praat TextGrids

[vtt-to-textgrid.jar](vtt-to-textgrid/index.html) 
is a utility for converting VTT files to TextGrids.

(If you prefer ELAN transcripts, try
[vtt-to-eaf.jar](vtt-to-eaf/index.html)
instead)

It's a Java program, so you must have a recent version of Java installed for it to work.

Downloading the 
[vtt-to-textgrid.jar](vtt-to-textgrid/index.html)
file and double-clicking it should work, but if not, you can run it from the command line like this:

```
java -jar vtt-to-textgrid.jar
```

When it starts, it looks like this:

![vtt-to-textgrid](images/vtt-to-textgrid.png)

You need to drag/drop vtt files into the big white space (or use the + button), and then click
*Convert*. This will save each TextGrid in the same folder as the VTT file.

