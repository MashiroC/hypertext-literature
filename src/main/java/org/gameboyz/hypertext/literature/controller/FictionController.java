package org.gameboyz.hypertext.literature.controller;

import lombok.extern.slf4j.Slf4j;
import org.gameboyz.hypertext.literature.been.ResponseEntity;
import org.gameboyz.hypertext.literature.execptions.fiction.SliceNotFoundException;
import org.gameboyz.hypertext.literature.pojo.Edge;
import org.gameboyz.hypertext.literature.pojo.Fiction;
import org.gameboyz.hypertext.literature.pojo.Slice;
import org.gameboyz.hypertext.literature.pojo.User;
import org.gameboyz.hypertext.literature.pojo.form.FictionForm;
import org.gameboyz.hypertext.literature.pojo.form.SliceForm;
import org.gameboyz.hypertext.literature.service.FictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author: Shiina18
 * @date: 2019/6/4 20:22
 * @description:
 */
@RestController
@Slf4j
public class FictionController {

    @Autowired
    FictionService fictionService;

    @GetMapping("/fictions")
    public ResponseEntity getAllfiction(@RequestAttribute(value = "user", required = false) User user) {
        if (user != null) {
            log.info("user:[uid:{},nickname:{}]获取了小说信息", user.getUid(), user.getNickname());
        } else {
            log.info("未登录用户获取了小说信息");
        }
        Set<Fiction> res = fictionService.getAllFictions();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/fiction/{fictionId}")
    public ResponseEntity getSlice(@RequestAttribute(value = "user", required = false) final User user, @PathVariable("fictionId") final Integer fictionId) {
        if (user != null) {
            log.info("user:[uid:{},nickname:{}]获取了小说[{}]的章节信息", user.getUid(), user.getNickname(), fictionId);
        } else {
            log.info("未登录用户获取了小说[{}]信息", fictionId);
        }
        Set<Edge> res = fictionService.getFictionSlice(fictionId);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/fiction/{fictionId}/{sliceId}")
    public ResponseEntity getOneContent(@PathVariable("fictionId") Integer fictionId, @PathVariable("sliceId") Integer sliceId, @RequestAttribute(value = "user", required = false) User user) throws SliceNotFoundException {
        if (user != null) {
            log.info("user:[uid:{},nickname:{}]获取了小说[{}]的片段[{}]信息", user.getUid(), user.getNickname(), fictionId, sliceId);
        } else {
            log.info("未登录用户获取了小说[{}]的片段[{}]信息", fictionId, sliceId);
        }
        Slice slice = fictionService.findContent(sliceId);
        return ResponseEntity.ok(slice);
    }

    @PostMapping("/addFiction")
    public ResponseEntity addFiction(@RequestBody FictionForm fictionForm, @RequestAttribute("user") User user) {
        log.info("user:[uid:{},nickname:{}]添加了fiction:[{}]", user.getUid(), user.getNickname(), fictionForm.getName());
        Fiction fiction = new Fiction(fictionForm, user);

        fictionService.addFiction(fiction, fictionForm.getContent());
        return ResponseEntity.ok();
    }

    @PostMapping("/addSlice")
    public ResponseEntity addSlice(@RequestBody SliceForm sliceForm, @RequestAttribute("user") User user) {
        log.info("user:[uid:{},nickname:{}]对fiction:[{}]添加了一个片段", user.getUid(), user.getNickname(), sliceForm.getFictionId());
        fictionService.addSlice(sliceForm, user.getUid());
        return ResponseEntity.ok();
    }


}
