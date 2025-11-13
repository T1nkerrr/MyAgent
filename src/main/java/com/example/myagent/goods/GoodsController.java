package com.example.myagent.goods;

import com.example.myagent.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IGoodsService goodsService;
    @RequestMapping("/all")
    public ResponseResult<Iterable<Goods>> getAllGoods(){
        return ResponseResult.success(goodsService.getAllGoods());
    }
}
