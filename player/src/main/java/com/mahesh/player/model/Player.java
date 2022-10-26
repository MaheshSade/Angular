package com.mahesh.player.model;

import lombok.Data;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Component
@Data
@Entity
@Table(name = "player")
public class Player {
    @Id
    @Column(name = "Jersey_No")
    int jerseyNo;
    @Column(name = "Name")
    String name;
    @Column(name = "Match_1")
    int match1;
    @Column(name = "Balls_1")
    int balls1;
    @Column(name = "Match_2")
    int match2;
    @Column(name = "Balls_2")
    int balls2;
    @Column(name = "Match_3")
    int match3;
    @Column(name = "Balls_3")
    int balls3;
    @Column(name = "Total")
    int total;
    @Column(name = "Strike_Rate")
    double strikeRate;

}
