package com.yinghuo.highway.util;

public class ImageUtils {

    /**
     * 将base64字符串转成图片
     * TODO
     * @param imgStr base64图片字符串
     * @param path 目标输出路径
     * @return
     */
//    public static boolean base64StrToImage(String imgStr, String path) {
//        if (imgStr == null)
//            return false;
//        BASE64Decoder decoder = new BASE64Decoder();
//        try {
//            // 解密base64图片字符串
//            byte[] b = decoder.decodeBuffer(imgStr);
//            // 处理数据,把负的byte字节数据改为正的,作用未知
//            for (int i = 0; i < b.length; ++i) {
//                if (b[i] < 0) {
//                    b[i] += 256;
//                }
//            }
//            File tempFile = new File(path);
//            //文件夹不存在则自动创建
//            if (!tempFile.getParentFile().exists()) {
//                tempFile.getParentFile().mkdirs();
//            }
//            OutputStream out = new FileOutputStream(tempFile);
//            out.write(b);
//            out.flush();
//            out.close();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }

    /* 图片转base64字符串
     * @param imgFile 图片路径
     * @return base64字符串格式的图片
     */
//    public static String imageToBase64Str(String imgFile) {
//        InputStream inputStream = null;
//        byte[] data = null;
//        try {
//            inputStream = new FileInputStream(imgFile);
//            data = new byte[inputStream.available()];  //根据文件流字节大小初始化data字节数组大小
//            inputStream.read(data);  //将流读入data
//            inputStream.close();  //关闭流
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //将图片数组加密
//        BASE64Encoder encoder = new BASE64Encoder();
//        return encoder.encode(data);
//    }
//
//    public static void main(String[] args) {
//        String base64Str = imageToBase64Str("D:/20190307/2.jpg");
//        System.out.println(base64Str);
//
//        boolean b = base64StrToImage(base64Str, "D:/3.jpg");
//        System.out.println(b);
//    }

}
