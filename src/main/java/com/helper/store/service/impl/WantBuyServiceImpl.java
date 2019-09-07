package com.helper.store.service.impl;

import com.helper.store.dao.WantBuyMapper;
import com.helper.store.domain.JsonMessage;
import com.helper.store.domain.WantBuy;
import com.helper.store.service.WantBuyService;
import com.helper.store.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanghao
 * @create 2019-07-02 15:29
 * @Description:
 */
@Service
@Slf4j
public class WantBuyServiceImpl implements WantBuyService {

    @Autowired
    WantBuyMapper wantBuyMapper;

    @Override
    public JsonMessage saveShoe(Integer id) {
        JsonMessage result = new JsonMessage();
        Map<String,Object> map = new HashMap<>(16);
        try {
            wantBuyMapper.saveShoe(id);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
            result.setData(map);
        }catch (Exception e) {
            log.info(e.toString());
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;

    }
}