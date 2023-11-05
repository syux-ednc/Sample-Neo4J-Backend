package com.syux.service;

import com.syux.model.InfoObj;
import com.syux.repository.InfoObjRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class InfoObjService {

    @Autowired
    private InfoObjRepository infoObjRepository;

    public List<InfoObj> getAllInfoObjs() {
        return infoObjRepository.findAll();
    }

    public InfoObj getInfoObjByName(String name) {
        return infoObjRepository.findInfoObjByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<InfoObj> getAncestorInfoObjs(String name) {
        return infoObjRepository.findAncestorNodes(name);
    }

    public List<InfoObj> getDescendantInfoObjs(String name) {
        return infoObjRepository.findDescendantNodes(name);
    }

    public void updateInfoObjStatus(String name, String oldStatus, String newStatus) {
        infoObjRepository.updateInfoObjStatus(name, oldStatus, newStatus);
    }

    public void deleteInfoObjByName(String name) {
        infoObjRepository.deleteInfoObjByName(name);
    }

    public void unlinkRelationshipToInfoObj(String name) {
        infoObjRepository.unlinkRelationshipToInfoObj(name);
    }

    public void unlinkRelationshipFromInfoObj(String name) {
        infoObjRepository.unlinkRelationshipFromInfoObj(name);
    }
}
