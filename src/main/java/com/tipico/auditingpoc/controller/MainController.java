package com.tipico.auditingpoc.controller;

import com.tipico.auditingpoc.annotations.LogExecutionTime;
import com.tipico.auditingpoc.bo.Team;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sports")
public class MainController {

    private Map<String, Team> teams = new HashMap<>();

    @LogExecutionTime
    @RequestMapping("/status")
    public String ping() {
        return "FORZA INTER!";
    }

    @LogExecutionTime
    @RequestMapping("/teams/{id}")
    public Team getTeamById(@PathVariable String id) {
        return teams.get(id) ;
    }

    @LogExecutionTime
    @RequestMapping(method = RequestMethod.PUT, path = "/teams")
    public void addTeam(@RequestBody Team team) {
        teams.put(team.getId(), team);
        return;
    }
}
