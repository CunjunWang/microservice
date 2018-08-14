package com.cunjunwang.order.utils;

import com.cunjunwang.order.VO.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("Success");
        resultVO.setData(object);

        return resultVO;
    }
}
