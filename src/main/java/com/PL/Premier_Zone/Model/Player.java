package com.PL.Premier_Zone.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // this means that the class  will be  mapped to table name player in the database
@Table(name="player_stats")
public class Player {
    @Id
    @Column(name="Player", unique = true)
    private String name;
    private String nation, team;
    private String pos;
    private int age;
    private float mp, minn, gls, ast, crdY, xG, xAG;

    public Player() {
    }

    public Player(String name, float xAG, float xG, float ast, float crdY, float gls, float minn, float mp, int age, String pos, String team, String nation) {
        this.name = name;
        this.xAG = xAG;
        this.xG = xG;
        this.ast = ast;
        this.crdY = crdY;
        this.gls = gls;
        this.minn = minn;
        this.mp = mp;
        this.age = age;
        this.pos = pos;
        this.team = team;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getMp() {
        return mp;
    }

    public void setMp(float mp) {
        this.mp = mp;
    }

    public float getMinn() {
        return minn;
    }

    public void setMinn(float minn) {
        this.minn = minn;
    }

    public float getGls() {
        return gls;
    }

    public void setGls(float gls) {
        this.gls = gls;
    }

    public float getAst() {
        return ast;
    }

    public void setAst(float ast) {
        this.ast = ast;
    }

    public float getCrdY() {
        return crdY;
    }

    public void setCrdY(float crdY) {
        this.crdY = crdY;
    }

    public float getxG() {
        return xG;
    }

    public void setxG(float xG) {
        this.xG = xG;
    }

    public float getxAG() {
        return xAG;
    }

    public void setxAG(float xAG) {
        this.xAG = xAG;
    }
}
