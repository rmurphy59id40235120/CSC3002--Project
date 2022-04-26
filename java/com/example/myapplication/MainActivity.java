package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;


public class MainActivity extends AppCompatActivity {

    private Button butterfliesButton, giftshopButton, dinosaurButton,
            mummyButton, cafeButton, mainentranceButton, stairsButton, toiletsButton;
    private Button leftButton, rightButton, upButton, downButton;
    private int currentPosition;
    private ImageView locationPointer;
    private int coordinateX, coordinateY;
    private TextView coordinatesText, currentPositionText;
    private String shortestPathString;
    private int[] pathArray, pathwayAudio;
    private String[] groupedPaths;
    private boolean destinationSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialising coordinates
        coordinateX = 0;
        coordinateY = 0;
        coordinatesText = findViewById(R.id.coordinatesText);
        coordinatesText.setText("(" + coordinateX + "," + coordinateY + ")");
        currentPositionText = findViewById(R.id.currentPositionText);

        // Populating pathways array
        int pathwayAudio[] = new int[50];
        for (int i = 0; i < 50; i++) {
            pathwayAudio[i] = 0;
        }

        ///////////////////////////////////////////////////////////////////////
        /////////////////////// Creating Weighted Graph ///////////////////////
        ///////////////////////////////////////////////////////////////////////

        int vertices = 15;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);graph.addEdge(1, 2);graph.addEdge(2, 3);
        graph.addEdge(2, 4);graph.addEdge(2, 5);graph.addEdge(5, 6);
        graph.addEdge(5, 7);graph.addEdge(5, 8);graph.addEdge(8, 9);
        graph.addEdge(9, 10);graph.addEdge(8, 11);graph.addEdge(8, 12);
        graph.addEdge(12,13);graph.addEdge(1, 5);graph.addEdge(1, 8);
        graph.addEdge(1, 11);graph.addEdge(2, 8);graph.addEdge(2, 11);
        graph.addEdge(5, 11);graph.addEdge(3, 4);graph.addEdge(6, 7);
        graph.addEdge(9, 12);graph.addEdge(1, 0);graph.addEdge(2,1);
        graph.addEdge(3, 2);graph.addEdge(4, 2);graph.addEdge(5,2);
        graph.addEdge(6,5);graph.addEdge(7,5);graph.addEdge(8,5);
        graph.addEdge(9,8);graph.addEdge(10,9);graph.addEdge(11,8);
        graph.addEdge(12,8);graph.addEdge(13,12);graph.addEdge(5,1);
        graph.addEdge(8,1);graph.addEdge(11,1);graph.addEdge(8,2);
        graph.addEdge(11,2);graph.addEdge(11,5);graph.addEdge(4,3);
        graph.addEdge(7,6);graph.addEdge(12,9);


        ///////////////////////////////////////////////////////////////////////
        /////////////////////// Buttons for Locations /////////////////////////
        ///////////////////////////////////////////////////////////////////////

        mainentranceButton = findViewById(R.id.mainEntranceButton);
        mainentranceButton.setBackgroundColor(Color.TRANSPARENT);
        mainentranceButton.setTextColor(Color.TRANSPARENT);
        mainentranceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPosition != -1) {
                    shortestPathString = graph.getShortestPath(currentPosition, 0);
                    pathArray = stringToArray(shortestPathString);
                    groupedPaths = groupPaths(pathArray);
                    destinationSelected = true;
                }
            }
        });

        stairsButton = findViewById(R.id.stairsButton);
        stairsButton.setBackgroundColor(Color.TRANSPARENT);
        stairsButton.setTextColor(Color.TRANSPARENT);
        stairsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPosition != -1) {
                    shortestPathString = graph.getShortestPath(currentPosition, 4);
                    pathArray = stringToArray(shortestPathString);
                    groupedPaths = groupPaths(pathArray);
                    destinationSelected = true;
                }
            }
        });

        toiletsButton = findViewById(R.id.toiletsButton);
        toiletsButton.setBackgroundColor(Color.TRANSPARENT);
        toiletsButton.setTextColor(Color.TRANSPARENT);
        toiletsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPosition != -1) {
                    shortestPathString = graph.getShortestPath(currentPosition, 3);
                    pathArray = stringToArray(shortestPathString);
                    groupedPaths = groupPaths(pathArray);
                    destinationSelected = true;
                }
            }
        });

        butterfliesButton = findViewById(R.id.butterfliesButton);
        butterfliesButton.setBackgroundColor(Color.TRANSPARENT);
        butterfliesButton.setTextColor(Color.TRANSPARENT);
        butterfliesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPosition != -1) {
                    shortestPathString = graph.getShortestPath(currentPosition, 6);
                    pathArray = stringToArray(shortestPathString);
                    groupedPaths = groupPaths(pathArray);
                    destinationSelected = true;
                }

            }
        });

        mummyButton = findViewById(R.id.mummyButton);
        mummyButton.setBackgroundColor(Color.TRANSPARENT);
        mummyButton.setTextColor(Color.TRANSPARENT);
        mummyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPosition != -1) {
                    shortestPathString = graph.getShortestPath(currentPosition, 11);
                    pathArray = stringToArray(shortestPathString);
                    groupedPaths = groupPaths(pathArray);
                    destinationSelected = true;
                }
            }
        });

        cafeButton = findViewById(R.id.cafeButton);
        cafeButton.setBackgroundColor(Color.TRANSPARENT);
        cafeButton.setTextColor(Color.TRANSPARENT);
        cafeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPosition != -1) {
                    shortestPathString = graph.getShortestPath(currentPosition, 13);
                    pathArray = stringToArray(shortestPathString);
                    groupedPaths = groupPaths(pathArray);
                    destinationSelected = true;
                }
            }
        });

        giftshopButton = findViewById(R.id.giftshopButton);
        giftshopButton.setBackgroundColor(Color.TRANSPARENT);
        giftshopButton.setTextColor(Color.TRANSPARENT);
        giftshopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPosition != -1) {
                    shortestPathString = graph.getShortestPath(currentPosition, 7);
                    pathArray = stringToArray(shortestPathString);
                    groupedPaths = groupPaths(pathArray);
                    destinationSelected = true;
                }
            }
        });

        dinosaurButton = findViewById(R.id.dinosaurButton);
        dinosaurButton.setBackgroundColor(Color.TRANSPARENT);
        dinosaurButton.setTextColor(Color.TRANSPARENT);
        dinosaurButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPosition != -1) {
                    shortestPathString = graph.getShortestPath(currentPosition, 10);
                    pathArray = stringToArray(shortestPathString);
                    groupedPaths = groupPaths(pathArray);
                    destinationSelected = true;
                }
            }
        });

        ///////////////////////////////////////////////////////////////////////
        ///////////////////// Buttons for User Movement ///////////////////////
        ///////////////////////////////////////////////////////////////////////

        locationPointer = (ImageView) findViewById(R.id.locationPointer);

        leftButton = findViewById(R.id.leftButton);
        leftButton.setBackgroundColor(Color.TRANSPARENT);
        leftButton.setTextColor(Color.BLACK);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                positionLeft();
            }
        });

        rightButton = findViewById(R.id.rightButton);
        rightButton.setBackgroundColor(Color.TRANSPARENT);
        rightButton.setTextColor(Color.BLACK);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                positionRight();
            }
        });

        upButton = findViewById(R.id.upButton);
        upButton.setBackgroundColor(Color.TRANSPARENT);
        upButton.setTextColor(Color.BLACK);
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                positionUp();
            }
        });

        downButton = findViewById(R.id.downButton);
        downButton.setBackgroundColor(Color.TRANSPARENT);
        downButton.setTextColor(Color.BLACK);
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                positionDown();
            }
        });

        ///////////////////////////////////////////////////////////////////////
        ///////////////////// Current Position Functions //////////////////////
        ///////////////////////////////////////////////////////////////////////


        Timer timer2 = new Timer();
        TimerTask t2 = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if ((coordinateX == 0) && (coordinateY == 0)) {
                            currentPosition = 0;
                            currentPositionText.setText("Current Position: " + currentPosition);
                        }  else if ((coordinateX == -5) && (coordinateY == 0)) {
                            currentPosition = 1;
                            currentPositionText.setText("Current Position: " + currentPosition);
                        } else if ((coordinateX == -5) && (coordinateY == 3)) {
                            currentPosition = 2;
                            currentPositionText.setText("Current Position: " + currentPosition);
                        } else if ((coordinateX == -7) && (coordinateY == 3)) {
                            currentPosition = 3;
                            currentPositionText.setText("Current Position: " + currentPosition);
                        } else if ((coordinateX == -3) && (coordinateY == 3)) {
                            currentPosition = 4;
                            currentPositionText.setText("Current Position: " + currentPosition);
                        } else if ((coordinateX == -5) && (coordinateY == 5)) {
                            currentPosition = 5;
                            currentPositionText.setText("Current Position: " + currentPosition);
                        } else if ((coordinateX == -9) && (coordinateY == 5)) {
                            currentPosition = 6;
                            currentPositionText.setText("Current Position: " + currentPosition);
                        } else if ((coordinateX == -1) && (coordinateY == 5)) {
                            currentPosition = 7;
                            currentPositionText.setText("Current Position: " + currentPosition);
                        } else if ((coordinateX == -5) && (coordinateY == 8)) {
                            currentPosition = 8;
                            currentPositionText.setText("Current Position: " + currentPosition);
                        } else if ((coordinateX == -10) && (coordinateY == 8)) {
                            currentPosition = 9;
                            currentPositionText.setText("Current Position: " + currentPosition);
                        } else if ((coordinateX == -10) && (coordinateY == 12)) {
                            currentPosition = 10;
                            currentPositionText.setText("Current Position: " + currentPosition);
                        } else if ((coordinateX == -5) && (coordinateY == 12)) {
                            currentPosition = 11;
                            currentPositionText.setText("Current Position: " + currentPosition);
                        } else if ((coordinateX == -1) && (coordinateY == 8)) {
                            currentPosition = 12;
                            currentPositionText.setText("Current Position: " + currentPosition);
                        } else if ((coordinateX == -1) && (coordinateY == 10)) {
                            currentPosition = 13;
                            currentPositionText.setText("Current Position: " + currentPosition);
                        } else {
                            currentPosition = -1;
                            currentPositionText.setText("Current Position: X");
                        }
                    }
                });
            }
        }; timer2.scheduleAtFixedRate(t2, 1000, 1000);

        Timer timer = new Timer();
        TimerTask t = new TimerTask() {
            @Override
            public void run() {
                if ((currentPosition != -1) && (destinationSelected == true)) {
                    findPathAudio(groupedPaths, pathwayAudio);
                };
            }
        }; timer.scheduleAtFixedRate(t, 1000, 1000);
    }

    ///////////////////////////////////////////////////////////////////////
    //////////////////// Methods for Pointer Navigation ///////////////////
    ///////////////////////////////////////////////////////////////////////

    private void positionLeft() {
        locationPointer.setX(locationPointer.getX() - 55);
        coordinateX = coordinateX - 1;
        coordinatesText.setText("(" + coordinateX + "," + coordinateY + ")");
    }

    private void positionRight() {
        locationPointer.setX(locationPointer.getX() + 55);
        coordinateX = coordinateX + 1;
        coordinatesText.setText("(" + coordinateX + "," + coordinateY + ")");
    }

    private void positionUp() {
        locationPointer.setY(locationPointer.getY() - 55);
        coordinateY = coordinateY + 1;
        coordinatesText.setText("(" + coordinateX + "," + coordinateY + ")");
    }

    private void positionDown() {
        locationPointer.setY(locationPointer.getY() + 55);
        coordinateY = coordinateY - 1;
        coordinatesText.setText("(" + coordinateX + "," + coordinateY + ")");
    }

    ///////////////////////////////////////////////////////////////////////
    /////////////////////// Methods for Audio Prompts /////////////////////
    ///////////////////////////////////////////////////////////////////////

    private void goStraight5Metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.gostraight5metres);
        music.start();
        System.out.println("Go straight 5 metres");
    }

    private void goStraight9metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.gostraight9metres);
        music.start();
        System.out.println("Go straight 9 metres");
    }

    private void goStraight7metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.gostraight7metres);
        music.start();
        System.out.println("Go straight 7 metres");
    }

    private void goStraight2metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.gostraight2metres);
        music.start();
        System.out.println("Go straight 2 metres");
    }

    private void goStraight3metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.gostraight3metres);
        music.start();
        System.out.println("Go straight 3 metres");
    }

    private void goStraight4metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.gostraight4metres);
        music.start();
        System.out.println("Go straight 4 metres");
    }

    private void turnRight5metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnright5metres);
        music.start();
        System.out.println("Turn right and go straight for 5 metres");
    }

    private void turnRight9metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnright9metres);
        music.start();
        System.out.println("Turn right and go straight for 9 metres");
    }

    private void turnRight7metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnright7metres);
        music.start();
        System.out.println("Turn right and go straight for 7 metres");
    }

    private void turnRight4metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnright4metres);
        music.start();
        System.out.println("Turn right and go straight for 4 metres");
    }

    private void turnLeft3metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnleft3metres);
        music.start();
        System.out.println("Turn left and go straight for 3 metres");
    }

    private void turnLeft7metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnleft7metres);
        music.start();
        System.out.println("Turn left and go straight for 7 metres");
    }

    private void turnLeft4metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnleft4metres);
        music.start();
        System.out.println("Turn left and go straight for 4 metres");
    }

    private void turnLeft5metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnleft5metres);
        music.start();
        System.out.println("Turn left and go straight for 5 metres");

    }

    private void turnLeft2metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnleft2metres);
        music.start();
        System.out.println("Turn right and go straight for 2 metres");
    }

    private void turnRight3metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnright3metres);
        music.start();
        System.out.println("Turn right and go straight for 3 metres");
    }

    private void turnRight8metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnright8metres);
        music.start();
        System.out.println("Turn right and go straight for 8 metres");
    }

    private void turnRight12metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnright12metres);
        music.start();
        System.out.println("Turn right and go straight for 12 metres");
    }

    private void turnRight2metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnright2metres);
        music.start();
        System.out.println("Turn right and go straight for 2 metres");
    }

    private void turnAround4metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnaround4metres);
        music.start();
    }

    private void turnAround2metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnaround2metres);
        music.start();
    }

    private void turnLeft9metres() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.turnleft9metres);
        music.start();
    }

    private void reachedLocation() {
        MediaPlayer music = MediaPlayer.create(MainActivity.this,
                R.raw.reacheddesiredlocation);
        music.start();
    }

    ///////////////////////////////////////////////////////////////////////
    ////////////////////// Methods for Weighted Graph /////////////////////
    ///////////////////////////////////////////////////////////////////////

    // A directed graph using
// adjacency list representation
    public class Graph {
        // No. of vertices in graph
        private int v;
        // Strings for paths
        private String shortestPathString;
        private List<Integer> shortestPath = new ArrayList<>();
        // adjacency list
        private ArrayList<Integer>[] adjList;

        // Constructor
        public Graph(int vertices) {
            // initialise vertex count
            this.v = vertices;
            // initialise adjacency list
            initAdjList();
        }

        // utility method to initialise
        // adjacency list
        @SuppressWarnings("unchecked")
        private void initAdjList() {
            adjList = new ArrayList[v];
            for (int i = 0; i < v; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        // add edge from u to v
        public void addEdge(int u, int v) {
            // Add v to u's list.
            adjList[u].add(v);
        }

        // Prints all paths from
        // 's' to 'd'
        public String getShortestPath(int s, int d) {
            boolean[] isVisited = new boolean[v];
            ArrayList<Integer> pathList = new ArrayList<>();
            // add source to path[]
            pathList.add(s);
            // Call recursive utility
            for(int i=0; i<15; i++){
                shortestPath.add(i);
            }
            calculateAllPaths(s, d, isVisited, pathList);
            shortestPathString = "";
            // using iterator for traversing a linkedlist
            Iterator<Integer> iterator = shortestPath.iterator();
            while (iterator.hasNext()) {
                // appending using "+" operator
                shortestPathString = shortestPathString + iterator.next() + " ";
            }
            System.out.println(shortestPathString);
            return shortestPathString;
        }

        // A recursive function to print all paths from 'u' to 'd'.
        // isVisited[] keeps track of vertices in current path.
        // localPathList<> stores actual
        // vertices in the current path
        private void calculateAllPaths(Integer u,
                                       Integer d,
                                       boolean[] isVisited,
                                       List<Integer> localPathList) {
            if (u.equals(d)) {
                // if match found then no need to traverse more till depth
                //System.out.println(localPathList);
                if(shortestPath.size() > localPathList.size())
                    shortestPath = new ArrayList<>(localPathList);
                return;
            }
            // Mark the current node
            isVisited[u] = true;
            // Recur for all the vertices
            // adjacent to current vertex
            for (Integer i : adjList[u]) {
                if (!isVisited[i]) {
                    // store current node
                    // in path[]
                    localPathList.add(i);
                    calculateAllPaths(i, d, isVisited, localPathList);
                    // remove current node
                    // in path[]
                    localPathList.remove(i);
                }
            }
        // Mark the current node
        isVisited[u] = false;
        }
    }

    private int[] stringToArray(String shortestPathString) {
        String splitString[];
        splitString = shortestPathString.split(" ");
        int pathArray[] = new int[splitString.length];
        for (int i = 0; i < splitString.length ; i++) {
            pathArray[i] = Integer.parseInt(splitString[i]);
        }
        return pathArray;
    }

    private String[] groupPaths(int[] pathArray) {
        String groupedPathways[] = new String[(pathArray.length-1)];
        for (int i = 0; i < groupedPathways.length; i++) {
            groupedPathways[i] = pathArray[i] + "," + pathArray[i+1];
        }
        return groupedPathways;
    }

    private void findPathAudio(String[] groupedPaths, int[] pathwayAudio) {
        for (int i = 0; i < groupedPaths.length; i++) {
            if ((groupedPaths[i].equals("0,1")) && (currentPosition == 0) && (pathwayAudio[0] == 0)) {
                goStraight5Metres();
                pathwayAudio[0] = 1;
            }
            if ((groupedPaths[i].equals("1,0")) && (currentPosition == 1) && (pathwayAudio[22] == 0)) {
                turnLeft5metres();
                pathwayAudio[22] = 1;
            }
            if ((groupedPaths[i].equals("1,2")) && (currentPosition == 1) && (pathwayAudio[1] == 0)) {
                turnRight3metres();
                pathwayAudio[1] = 1;
            }
            if ((groupedPaths[i].equals("1,5")) && (currentPosition == 1) && (pathwayAudio[13] == 0)) {
                turnRight5metres();
                pathwayAudio[13] = 1;
            }
            if ((groupedPaths[i].equals("1,8")) && (currentPosition == 1) && (pathwayAudio[14] == 0)) {
                turnRight8metres();
                pathwayAudio[14] = 1;
            }
            if ((groupedPaths[i].equals("1,11")) && (currentPosition == 1) && (pathwayAudio[15] == 0)) {
                turnRight12metres();
                pathwayAudio[15] = 1;
            }
            if ((groupedPaths[i].equals("9,10")) && (currentPosition == 9) && (pathwayAudio[9] == 0)) {
                turnRight4metres();
                pathwayAudio[9] = 1;
            }
            if ((groupedPaths[i].equals("10,9")) && (currentPosition == 10) && (pathwayAudio[31] == 0)) {
                turnAround4metres();
                pathwayAudio[31] = 1;
            }
            if ((groupedPaths[i].equals("9,8")) && (currentPosition == 9) && (pathwayAudio[30] == 0)) {
                turnLeft5metres();
                pathwayAudio[30] = 1;
            }
            if ((groupedPaths[i].equals("9,12")) && (currentPosition == 9) && (pathwayAudio[21] == 0)) {
                turnLeft9metres();
                pathwayAudio[21] = 1;
            }
            if ((groupedPaths[i].equals("11,8")) && (currentPosition == 11) && (pathwayAudio[32] == 0)) {
                turnAround4metres();
                pathwayAudio[32] = 1;
            }
            if ((groupedPaths[i].equals("13,12")) && (currentPosition == 13) && (pathwayAudio[34] == 0)) {
                turnAround2metres();
                pathwayAudio[34] = 1;
            }
            if ((groupedPaths[i].equals("12,13")) && (currentPosition == 12) && (pathwayAudio[12] == 0)) {
                turnLeft2metres();
                pathwayAudio[12] = 1;
            }
            if ((groupedPaths[i].equals("2,3")) && (currentPosition == 2) && (pathwayAudio[2] == 0)) {
                if (i != 0) {
                    if (groupedPaths[i-1].equals("5,2")) {
                        turnRight2metres();
                    } else {
                        turnLeft2metres();
                    }
                }
                pathwayAudio[2] = 1;
            }
            if ((groupedPaths[i].equals("2,4")) && (currentPosition == 2) && (pathwayAudio[3] == 0)) {
                if (i != 0) {
                    if (groupedPaths[i-1].equals("5,2")) {
                        turnLeft2metres();
                    } else {
                        turnRight2metres();
                    }
                }
                pathwayAudio[3] = 1;
            }
            if ((groupedPaths[i].equals("2,5")) && (currentPosition == 2) && (pathwayAudio[4] == 0)) {
                if (i != 0) {
                    if (groupedPaths[i-1].equals("3,2")) {
                        turnLeft3metres();
                    } else if (groupedPaths[i-1].equals("4,2")) {
                        turnRight3metres();
                    } else {
                        goStraight2metres();
                    }
                }
                pathwayAudio[4] = 1;
            }
            if ((groupedPaths[i].equals("5,6")) && (currentPosition == 5) && (pathwayAudio[5] == 0)) {
                if (i != 0) {
                    if (groupedPaths[i-1].equals("8,5")) {
                        turnRight4metres();
                    } else {
                        turnLeft4metres();
                    }
                }
                pathwayAudio[5] = 1;
            }
            if ((groupedPaths[i].equals("5,7")) && (currentPosition == 5) && (pathwayAudio[6] == 0)) {
                if (i != 0) {
                    if (groupedPaths[i-1].equals("8,5")) {
                        turnLeft4metres();
                    } else {
                        turnRight4metres();
                    }
                }
                pathwayAudio[6] = 1;
            }
            if ((groupedPaths[i].equals("5,8")) && (currentPosition == 5) && (pathwayAudio[7] == 0)) {
                if (i != 0) {
                    if (groupedPaths[i-1].equals("6,5")) {
                        turnLeft3metres();
                    } else if (groupedPaths[i-1].equals("7,5")) {
                        turnRight3metres();
                    } else {
                        goStraight3metres();
                    }
                }
                pathwayAudio[7] = 1;
            }
            if ((groupedPaths[i].equals("8,9")) && (currentPosition == 8) && (pathwayAudio[8] == 0)) {
                if (i != 0) {
                    if (groupedPaths[i-1].equals("11,8")) {
                        turnRight5metres();
                    } else {
                        turnLeft5metres();
                    }
                }
                pathwayAudio[8] = 1;
            }
            if ((groupedPaths[i].equals("8,11")) && (currentPosition == 8) && (pathwayAudio[10] == 0)) {
                if (i != 0) {
                    if (groupedPaths[i-1].equals("9,8")) {
                        turnLeft4metres();
                    } else if (groupedPaths[i-1].equals("12,8")) {
                        turnRight4metres();
                    } else {
                        goStraight4metres();
                    }
                }
                pathwayAudio[10] = 1;
            }
            if ((groupedPaths[i].equals("8,12")) && (currentPosition == 8) && (pathwayAudio[11] == 0)) {
                if (i != 0) {
                    if (groupedPaths[i-1].equals("11,8")) {
                        turnLeft4metres();
                    } else {
                        turnRight4metres();
                    }
                }
                pathwayAudio[11] = 1;
            }
            if ((groupedPaths[i].equals("2,8")) && (currentPosition == 2) && (pathwayAudio[16] == 0)) {
                if (i != 0) {
                    if (groupedPaths[i-1].equals("3,2")) {
                        turnLeft5metres();
                    } else if (groupedPaths[i-1].equals("4,2")) {
                        turnRight5metres();
                    } else {
                        goStraight5Metres();
                    }
                }
                pathwayAudio[16] = 1;
            }
            if ((groupedPaths[i].equals("2,11")) && (currentPosition == 2) && (pathwayAudio[17] == 0)) {
                if (i != 0) {
                    if (groupedPaths[i-1].equals("3,2")) {
                        turnLeft9metres();
                    } else if (groupedPaths[i-1].equals("4,2")) {
                        turnRight9metres();
                    } else {
                        goStraight9metres();
                    }
                }
                pathwayAudio[17] = 1;
            }
            if ((groupedPaths[i].equals("5,11")) && (currentPosition == 5) && (pathwayAudio[18] == 0)) {
                if (i != 0) {
                    if (groupedPaths[i-1].equals("6,5")) {
                        turnLeft7metres();
                    } else if (groupedPaths[i-1].equals("7,5")) {
                        turnRight7metres();
                    } else {
                        goStraight7metres();
                    }
                }
                pathwayAudio[18] = 1;
            }
        }
    }
}



