# Music Library Database & Player

## Overview

The main idea is to have a simple program that takes a few of bits of
inforamtion about a song or piece of music from a user via stdin. The program
will then enter that information into a SQLite database for later querying /
playing.

## Running the Program

The program requires the Java Database Connectivity (JDBC) API in order to
connect to the SQLite database. You can download the latest version of the
required jar file from [their releases
page](https://github.com/xerial/sqlite-jdbc/releases).

This is a simple interactive CLI program. After compiling the program with 
`javac Main.java`, the user can start the program using the command below.

```
java -classpath ".:sqlite-jdbc-3.40.1.0.jar" Main
```

There's then an interactive menu with some options for the user.

```
##### Java Music Database & Player #####

 1) Enter a New Song
 2) List All Songs
 3) Search for a Song
 4) Delete a song
 5) Play a Song
 q) Quit

What would you like to do? (1,2,3,4,5,q):
```

### External Music Player

This is just a sample project and the java audio libraries look hard. Maybe
someday I'll do this all in java, but for right now I'm using the external
program `mpv` to play the music files. You could use `vlc` or whatever you have
installed on your system.
