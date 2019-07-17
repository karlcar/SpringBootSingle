package springBoot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import springBoot.po.User;
import springBoot.po.UserExample;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);
	
    List<User> selectByExample(UserExample example);
	
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
    
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);
    
    User selectByPrimaryKey(Integer id);
    
    List<User> selectUserByPage(Map<String, Object> paramMap);
    List<User> selectUserByPage2(Map<String, Object> paramMap);

	int selectUserByTotal();
	int selectUserByTotal2(String nickname);

	int updateByPrimaryKeySelective(User user);
	
	//根据用户昵称搜索条件
//	List<User> findOrdersByCon(@Param("username") String username);
}