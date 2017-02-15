#PlayerRank

Android implementation of a basketball guessing game: each round, choose the player who's ranked highest. 

##To run it
The project was developed in and runs from the [Android Studio](https://developer.android.com/studio/index.html) IDE.

##About
Emulator screenshots at MVP-ish stage:

![MVP screenshots](https://github.com/katemanson/player_rank/raw/master/images/PlayerRank_MVP.png)

###Planning
'Before' and 'after' MoSCoW (Must, Could, Should, Would) boards:

![initial MoSCoW](https://github.com/katemanson/player_rank/raw/master/images/PlayerRank_Trello_before.png)
![final MoSCoW](https://github.com/katemanson/player_rank/raw/master/images/PlayerRank_Trello_after.png)

###Tech
* Java in Android Studio
* Unit tested with JUnit
* Debugged by logging and using breakpoints within Android Studio
* JSON data parsed to Java objects with [Gson](https://github.com/google/gson)

###New things, learning points
* HTTP requests in Java
* Parsing JSON in Java
* Using fragments and images in Android

###Highlights
* ^^^New things
* Implementing Java's Comparable interface to enable sorting of Athlete objects by ranking points: 

```
public class Athlete implements Comparable<Athlete> {

...

    public int compareTo(Athlete anotherAthlete) {
        double pointsDiff = this.getPoints() - anotherAthlete.getPoints();
        if (pointsDiff > 0) return 1;
        if (pointsDiff < 0) return -1;
        else return 0;
    }
}
```

