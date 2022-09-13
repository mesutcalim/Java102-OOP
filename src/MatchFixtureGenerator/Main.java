package MatchFixtureGenerator;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd=new Random();
        ArrayList<String> list=new ArrayList<>();
        ArrayList<String> oldMatchList= new ArrayList<>();
        list.add("Galatasaray");
        list.add("Bursaspor");
        list.add("Fenerbahçe");
        list.add("Beşiktaş");
        list.add("Başakşehir");
        list.add("Trabzonspor");
        list.add("Boluspor");
        if(list.size()%2 != 0){
            list.add("Bay");
        }
        ArrayList<String> teams = new ArrayList<>();
        int teamCount = list.size();
        int Round = ((list.size()-1)*2);
        int matchPerRound = list.size()/2;
        int counter=0;
        while(counter<=Round){
            teams.addAll(list);
            System.out.println((counter+1)+ ". Round");
            int sayac=0;
            while(sayac!=matchPerRound){
                String team1 = teams.get(rnd.nextInt(teams.size()));
                String team2 = teams.get(rnd.nextInt(teams.size()));
                if(!team1.equals(team2) && !oldMatchList.contains(team1 +" vs "+ team2)){
                    oldMatchList.add(team1 + " vs "+team2);
                    System.out.println(team1 + " vs "+team2);
                    //System.out.println(Round);
                    teams.remove(team1);
                    teams.remove(team2);
                    sayac+=1;
                }
            }
            counter+=1;
            System.out.println(counter);
        }


    }
}
