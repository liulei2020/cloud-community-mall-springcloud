package top.liulei.cloud.community.mall.common.util;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.codec.binary.Base64;
import top.liulei.cloud.community.mall.common.common.Constant;


/**
 * MD5工具，通过哈希算法将密码加密，为防止破解网站破解，还需要添加复杂的SALT盐值
 */
public class MD5Utils {
    public static String getMD5Str(String strValue) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return Base64.encodeBase64String(md5.digest((strValue + Constant.SALT)
                .getBytes()));
    }

    //用这个方法测试生成的MD5的值
    public static void main(String[] args) {
        String md5 = null;
        try {
            md5 = getMD5Str("1234");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(md5);
    }
}
