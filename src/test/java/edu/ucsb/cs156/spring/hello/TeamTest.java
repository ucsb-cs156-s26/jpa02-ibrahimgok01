package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_test_case1_and_null_object() {

        Team team1 = new Team("Team1");
        team1.addMember("p1");
        team1.addMember("p2");

        Team team2 = new Team("Team1");
        team2.addMember("p1");
        team2.addMember("p2");

        Team team3 = new Team("Team3");
        team3.addMember("p1");
        team3.addMember("p2");

        Team team4 = new Team("Team4");
        team4.addMember("p1");
        team4.addMember("p3");

        Team team5 = new Team("Team5");
        team5.addMember("x");
        team5.addMember("y");

        Team team6 = new Team("Team6");
        team6.addMember("p1");
        team6.addMember("p2");

        Team team7 = new Team("Team6");
        team7.addMember("p1");
        team7.addMember("p2");

        assertEquals(true, team1.equals(team1));
        assertEquals(false, team1.equals(null));
        assertEquals(false, team1.equals("not team obj"));
        assertEquals(true, team1.equals(team2));
        assertEquals(false, team1.equals(team3));
        assertEquals(false, team1.equals(team4));
        assertEquals(false, team1.equals(team5));
        assertEquals(true, team6.equals(team7));
        assertEquals(true, team7.equals(team6));
    }

    @Test
    public void hashCode_test() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_test_edge_case() {
        Team team = new Team();
        int result = team.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }


    




}
