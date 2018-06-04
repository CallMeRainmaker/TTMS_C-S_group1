
import TTMS_Server.config.database.DbConfig;
import TTMS_Server.config.database.MyBatis;
import TTMS_Server.config.spring.RootConfig;
import TTMS_Server.config.spring.WebConfig;
import TTMS_Server.config.spring.WebInit;
import TTMS_Server.model.Employee;
import TTMS_Server.model.Play;
import TTMS_Server.model.Studio;
import TTMS_Server.service.EmployeeService;
import TTMS_Server.service.PlayService;
import TTMS_Server.service.StudioService;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = {RootConfig.class,WebConfig.class,WebInit.class,MyBatis.class,DbConfig.class})
@WebAppConfiguration("src/main/resources") //1 此注解指定web资源的位置，默认为src/main/webapp
public class PlayTest {


    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Autowired
    private PlayService playService;

    @Test
    public void test(){
        //增加
        Play play = new Play(1,1,"速度与激情",
                "测试",120,new BigDecimal("60"),Short.parseShort("1"));
        if (playService.addPlay(play))
           System.out.println("添加成功");
        else
           System.out.println("该剧目已存在");
        //删除
//        if (studioService.deleteStudioById(1))
//           System.out.println("删除成功");
//        else
//           System.out.println("该演出厅不存在");
//
        //修改
        /*Studio studio_new = new Studio("万达",5,5,"修改",1);
        studio_new.setStudio_id(2);
        if (studioService.updateStudioById(studio_new))
            System.out.println("更新成功");
        else
            System.out.println("该演出厅已存在");*/
    }


}