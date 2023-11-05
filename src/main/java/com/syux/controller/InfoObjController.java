package com.syux.controller;

import com.syux.model.InfoObj;
import com.syux.service.InfoObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/infoObjs")
public class InfoObjController {

    @Autowired
    private InfoObjService infoObjService;

    @GetMapping("/getAllInfoObjs")
    public ResponseEntity<List<InfoObj>> getAllInfoObjs() {
        return ResponseEntity.status(HttpStatus.OK).body(infoObjService.getAllInfoObjs());
    }

    @GetMapping("/getInfoObjByName")
    public ResponseEntity<InfoObj> getInfoObjByName(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(infoObjService.getInfoObjByName(name));
    }

    @GetMapping("/getAncestorInfoObj")
    public ResponseEntity<List<InfoObj>> getAncestorInfoObj(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(infoObjService.getAncestorInfoObjs(name));
    }

    @GetMapping("/getDescendantInfoObj")
    public ResponseEntity<List<InfoObj>> getDescendantInfoObj(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(infoObjService.getDescendantInfoObjs(name));
    }

    @PostMapping("/updateInfoObjStatus")
    public ResponseEntity<Object> updateInfoObjStatus(
            @RequestParam String name,
            @RequestParam String oldStatus,
            @RequestParam String newStatus
    ) {
        try {
            infoObjService.updateInfoObjStatus(name, oldStatus, newStatus);
            return ResponseEntity.status(HttpStatus.OK).body("SUCCESS");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteInfoObjByName")
    public ResponseEntity<Object> deleteInfoObjByName(@RequestParam String name) {
        try {
            infoObjService.deleteInfoObjByName(name);
            return ResponseEntity.status(HttpStatus.OK).body("SUCCESS");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR: " + e.getMessage());
        }
    }

    @DeleteMapping("/unlinkRelationshipToInfoObj")
    public ResponseEntity<Object> unlinkRelationshipToInfoObj(@RequestParam String name) {
        try {
            infoObjService.unlinkRelationshipToInfoObj(name);
            return ResponseEntity.status(HttpStatus.OK).body("SUCCESS");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR: " + e.getMessage());
        }
    }

    @DeleteMapping("/unlinkRelationshipFromInfoObj")
    public ResponseEntity<Object> unlinkRelationshipFromInfoObj(@RequestParam String name) {
        try {
            infoObjService.unlinkRelationshipFromInfoObj(name);
            return ResponseEntity.status(HttpStatus.OK).body("SUCCESS");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR: " + e.getMessage());
        }
    }
}
