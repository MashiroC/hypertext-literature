package org.gameboyz.hypertext.literature.controller;

import lombok.extern.slf4j.Slf4j;
import org.gameboyz.hypertext.literature.been.ResponseEntity;
import org.gameboyz.hypertext.literature.execptions.fiction.SliceNotFoundException;
import org.gameboyz.hypertext.literature.pojo.Content;
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

    @GetMapping("/articles")
    public ResponseEntity getAllArticle(@RequestAttribute("user") final User user) {
        if (user != null) {
            log.info("user:[uid:{},nickname:{}]获取了小说信息", user.getUid(), user.getNickname());
        } else {
            log.info("未登录用户获取了小说信息");
        }
        Set<Fiction> res = fictionService.getAllFictions();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/articles/${articleId}")
    public ResponseEntity getSlice(@RequestAttribute("user") final User user, @PathVariable("articleId") final Integer articleId) {
        if (user != null) {
            log.info("user:[uid:{},nickname:{}]获取了小说[{}]的章节信息", user.getUid(), user.getNickname(), articleId);
        } else {
            log.info("未登录用户获取了小说[{}]信息", articleId);
        }
        Set<Slice> res = fictionService.getFictionSlice(articleId);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/articles/${articleId}/${sliceId}")
    public ResponseEntity getOneContent(@PathVariable("articleId") Integer articleId, @PathVariable("sliceId") Integer sliceId, @RequestAttribute("user") User user) throws SliceNotFoundException {
        if (user != null) {
            log.info("user:[uid:{},nickname:{}]获取了小说[{}]的片段[{}]信息", user.getUid(), user.getNickname(), articleId, sliceId);
        } else {
            log.info("未登录用户获取了小说[{}]的片段[{}]信息", articleId, sliceId);
        }
        Content content = fictionService.findContent(sliceId);
        return ResponseEntity.ok(content);
    }

    @PostMapping("/articles/${articleId}")
    public ResponseEntity addSlice(@RequestBody SliceForm sliceForm, @RequestAttribute("user") User user, @PathVariable("articleId") Integer articleId) {
        log.info("user:[uid:{},nickname:{}]对article:[{}]添加了一个片段", user.getUid(), user.getNickname(), articleId);
        Slice slice = new Slice(articleId, sliceForm, user);
        fictionService.addSlice(slice);
        return ResponseEntity.ok();
    }

    @PostMapping("/fiction")
    public ResponseEntity addArticle(@RequestBody FictionForm fictionForm, @RequestAttribute("user") User user) {
        log.info("user:[uid:{},nickname:{}]添加了article:[{}]", user.getUid(), user.getNickname(), fictionForm.getName());
        Fiction fiction = new Fiction(fictionForm, user);
        Slice slice = new Slice(fictionForm, user);
        fictionService.addArticle(fiction, slice);
        return ResponseEntity.ok();
    }


}
