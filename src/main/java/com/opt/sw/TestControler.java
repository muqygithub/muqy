package com.opt.sw;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.opt.sw.model.TestClass;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;



/**
 * @ClassName: TC
 * @Description: TODO
 * @author muqingyang
 * @date 2017年1月9日 上午11:52:24
 * 
 */
@Api(value = "/test", description = "测试类")
@Controller
@RequestMapping("/test")
public class TestControler {


	
	@RequestMapping(value = "/testclass", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "查询信息", notes = "通过id获取列表信息")	
	public TestClass getTest(
							  @ApiParam(value="主键")
							  @RequestParam String filterID) {	
		TestClass tc1 = new TestClass();
		tc1.setStringField("abc");
		tc1.setIntegerField(123);
		TestClass tc2 = new TestClass();
		tc2.setStringField("def");
		tc2.setIntegerField(456);
		if(filterID.equals(tc1.getStringField())){
			return tc1;
		} else if(filterID.equals(tc1.getStringField())){
			return tc2;
		} else {
			return null;
		}
	}
	
	@RequestMapping(value = "/testclass", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "更新信息", notes = "id获取更新信息")
	public TestClass updateTest(
								@ApiParam(value="主键")
								@RequestParam String classId,
								@ApiParam(value="更新值")
								@RequestParam String classValue) {
		TestClass tc1 = new TestClass();
		tc1.setStringField(classId);
		tc1.setIntegerField(123);
		return tc1;
	}
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1() {
		return "test1";
	}

}
