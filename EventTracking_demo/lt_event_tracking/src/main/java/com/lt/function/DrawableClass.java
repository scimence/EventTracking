package com.lt.function;

import java.util.HashMap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;


/** DrawableClass.java: 图像资源封装类，将图像资源转化为字符串形式，存储在当前类代码中。getDrawable(图像名称)获取对应的图像 ----- 2018-11-9 下午5:37:30 wangzhongyuan */
public class DrawableClass
{
    private static HashMap<String, String> picDatas = new HashMap<String, String>();

    /** 设置图像和其对应数据 */
    private static void InitPics()
    {
        if (picDatas.size() == 0)
        {

            //			picDatas.put(
            //					"thumbsup_close",
            //					"89504e470d0a1a0a0000000d49484452000000200000001f08060000008656cf8c000000097048597300000b1300000b1301009a9c1800000a4d6943435050686f746f73686f70204943432070726f66696c65000078da9d53775893f7163edff7650f5642d8f0b1976c81002223ac08c81059a21092006184101240c585880a561415119c4855c482d50a489d88e2a028b867418a885a8b555c38ee1fdca7b57d7aefededfbd7fbbce79ce7fcce79cf0f8011122691e6a26a003952853c3ad81f8f4f48c4c9bd80021548e0042010e6cbc26705c50000f00379787e74b03ffc01af6f00020070d52e2412c7e1ff83ba50265700209100e02212e70b01905200c82e54c81400c81800b053b3640a009400006c797c422200aa0d00ecf4493e0500d8a993dc1700d8a21ca908008d0100992847240240bb00605581522c02c0c200a0ac40222e04c0ae018059b632470280bd0500768e58900f4060008099422ccc0020380200431e13cd03204c03a030d2bfe0a95f7085b8480100c0cb95cd974bd23314b895d01a77f2f0e0e221e2c26cb142611729106609e4229c979b231348e7034cce0c00001af9d1c1fe383f90e7e6e4e1e666e76ceff4c5a2fe6bf06f223e21f1dffebc8c020400104ecfefda5fe5e5d60370c701b075bf6ba95b00da560068dff95d33db09a05a0ad07af98b7938fc401e9ea150c83c1d1c0a0b0bed2562a1bd30e38b3eff33e16fe08b7ef6fc401efedb7af000719a4099adc0a383fd71616e76ae528ee7cb0442316ef7e723fec7857ffd8e29d1e234b15c2c158af15889b850224dc779b952914421c995e212e97f32f11f96fd0993770d00ac864fc04eb607b5cb6cc07eee01028b0e58d27600407ef32d8c1a0b91001067343279f7000093bff98f402b0100cd97a4e30000bce8185ca894174cc608000044a0812ab041070cc114acc00e9cc11dbcc01702610644400c24c03c104206e4801c0aa11896411954c03ad804b5b0031aa0119ae110b4c131380de7e0125c81eb70170660189ec218bc86090441c8081361213a8811628ed822ce0817998e04226148349280a420e988145122c5c872a402a9426a915d4823f22d7214398d5c40fa90dbc820328afc8abc47319481b25103d4027540b9a81f1a8ac6a073d174340f5d8096a26bd11ab41e3d80b6a2a7d14be87574007d8a8e6380d1310e668cd9615c8c87456089581a26c71663e55835568f35631d583776151bc09e61ef0824028b8013ec085e8410c26c82909047584c5843a825ec23b412ba085709838431c2272293a84fb4257a12f9c478623ab1905846ac26ee211e219e255e270e135f9348240ec992e44e0a21259032490b496b48db482da453a43ed210699c4c26eb906dc9dee408b280ac209791b7900f904f92fbc9c3e4b7143ac588e24c09a22452a494124a35653fe504a59f324299a0aa51cda99ed408aa883a9f5a496da076502f5387a91334759a25cd9b1643cba42da3d5d09a696769f7682fe974ba09dd831e4597d097d26be807e9e7e983f4770c0d860d83c7486228196b197b19a718b7192f994ca605d39799c85430d7321b9967980f986f55582af62a7c1591ca12953a9556957e95e7aa545573553fd579aa0b54ab550fab5e567da64655b350e3a909d416abd5a91d55bba936aece5277528f50cf515fa3be5ffd82fa630db2868546a08648a35463b7c6198d2116c63265f15842d6725603eb2c6b984d625bb2f9ec4c7605fb1b762f7b4c534373aa66ac6691669de671cd010ec6b1e0f039d99c4ace21ce0dce7b2d032d3f2db1d66aad66ad7ead37da7adabeda62ed72ed16edebdaef75709d409d2c9df53a6d3af77509ba36ba51ba85badb75cfea3ed363eb79e909f5caf50ee9ddd147f56df4a3f517eaefd6efd11f373034083690196c313863f0cc9063e86b9869b8d1f084e1a811cb68ba91c468a3d149a327b826ee8767e33578173e66ac6f1c62ac34de65dc6b3c61626932dba4c4a4c5e4be29cd946b9a66bad1b4d374ccccc82cdcacd8acc9ec8e39d59c6b9e61bed9bcdbfc8d85a5459cc54a8b368bc796da967ccb05964d96f7ac98563e567956f556d7ac49d65ceb2ceb6dd6576c501b579b0c9b3a9bcbb6a8ad9badc4769b6ddf14e2148f29d229f5536eda31ecfcec0aec9aec06ed39f661f625f66df6cf1dcc1c121dd63b743b7c727475cc766c70bceba4e134c3a9c4a9c3e957671b67a1739df33517a64b90cb1297769717536da78aa76e9f7acb95e51aeebad2b5d3f5a39bbb9bdcadd96dd4ddcc3dc57dabfb4d2e9b1bc95dc33def41f4f0f758e271cce39da79ba7c2f390e72f5e765e595efbbd1e4fb39c269ed6306dc8dbc45be0bdcb7b603a3e3d65facee9033ec63e029f7a9f87bea6be22df3dbe237ed67e997e07fc9efb3bfacbfd8ff8bfe179f216f14e056001c101e501bd811a81b3036b031f049904a50735058d05bb062f0c3e15420c090d591f72936fc017f21bf96333dc672c9ad115ca089d155a1bfa30cc264c1ed6118e86cf08df107e6fa6f94ce9ccb60888e0476c88b81f69199917f97d14292a32aa2eea51b453747174f72cd6ace459fb67bd8ef18fa98cb93bdb6ab6727667ac6a6c526c63ec9bb880b8aab8817887f845f1971274132409ed89e4c4d8c43d89e37302e76c9a339ce49a54967463aee5dca2b917e6e9cecb9e773c593559907c3885981297b23fe5832042502f184fe5a76e4d1d13f2849b854f45bea28da251b1b7b84a3c92e69d5695f638dd3b7d43fa68864f4675c633094f522b79911992b923f34d5644d6deaccfd971d92d39949c949ca3520d6996b42bd730b728b74f662b2b930de479e66dca1b9387caf7e423f973f3db156c854cd1a3b452ae500e164c2fa82b785b185b78b848bd485ad433df66feeaf9230b82167cbd90b050b8b0b3d8b87859f1e022bf45bb16238b5317772e315d52ba647869f0d27dcb68cbb296fd50e2585255f26a79dcf28e5283d2a5a5432b82573495a994c9cb6eaef45ab9631561956455ef6a97d55b567f2a17955fac70aca8aef8b046b8e6e2574e5fd57cf5796ddadade4ab7caedeb48eba4eb6eacf759bfaf4abd6a41d5d086f00dad1bf18de51b5f6d4ade74a17a6af58ecdb4cdcacd03356135ed5bccb6acdbf2a136a3f67a9d7f5dcb56fdadabb7bed926dad6bfdd777bf30e831d153bdeef94ecbcb52b78576bbd457df56ed2ee82dd8f1a621bbabfe67eddb847774fc59e8f7ba57b07f645efeb6a746f6cdcafbfbfb2096d52368d1e483a70e59b806fda9bed9a77b5705a2a0ec241e5c127dfa67c7be350e8a1cec3dcc3cddf997fb7f508eb48792bd23abf75ac2da36da03da1bdefe88ca39d1d5e1d47beb7ff7eef31e36375c7358f579ea09d283df1f9e48293e3a764a79e9d4e3f3dd499dc79f74cfc996b5d515dbd6743cf9e3f1774ee4cb75ff7c9f3dee78f5df0bc70f422f762db25b74bad3dae3d477e70fde148af5b6feb65f7cbed573cae74f44deb3bd1efd37ffa6ac0d573d7f8d72e5d9f79bdefc6ec1bb76e26dd1cb825baf5f876f6ed17770aee4cdc5d7a8f78affcbedafdea07fa0fea7fb4feb165c06de0f860c060cfc3590fef0e09879efe94ffd387e1d247cc47d52346238d8f9d1f1f1b0d1abdf264ce93e1a7b2a713cfca7e56ff79eb73abe7dffde2fb4bcf58fcd8f00bf98bcfbfae79a9f372efaba9af3ac723c71fbcce793df1a6fcadcedb7defb8efbadfc7bd1f9928fc40fe50f3d1fa63c7a7d04ff73ee77cfefc2ff784f3fb25d29f33000000206348524d00007a25000080830000f9ff000080e9000075300000ea6000003a980000176f925fc5460000024f4944415478dac497c14bdb5018c07f4959656ca9633b0816d6a159c183d0622f3b0d0a3b1406f55028050b15c4ebfc13f20f0c468fbb7af0b2930ebd8850b5d88363430f8238a46c86c5c3585751d621ee928c244dd3e6c575dfed7def0bbf5f1e2fdf7b91aa8a82195160112800cfccf16d4607d803de016fcd3192291007de032986139f8097c0996cbee9c610e198ac0d202a9bcb3ecdf0631a588ce446465e038fadec7836cbd3f979eec5e37c3f38084d51e7e6785228204912edd353f7744caa2aca2f6bc3c5549517abab489108009f5756f8a869c2f0b4a631592a0170737dcde6ec2cade363c7c694edbb7d3499fc0b07982c95480b0ad8e1005224424c55dd6551d93e32ea752e75dd512122e186035cea3a46bdde55eb10e8b45a6c572a5c1986b08417fcca30d8ae54e8b45afe020017cd26b5725948a217bc562e73d16c7a3e237b25452444e03d05824a88c27d0506950803b7ce829b7e45f713099e2f2f73776ccc91ff7972d2f5690581f75d817e2b11163eb0809f44187820014be2bcd1f09c3b6f3402c3030ba4358d443eef3997c8e785dab61ca6bdba43a46dcb61daebeec242a8b63d9080df77fe6d6747b86d0f24304893097376f80a04e9706124e4db3a584425ba04268a45e1deee2731512cf614e8d8130f53a9501dae97c4a39919cf7219f860cf7c5d5f775ca344daab2561bfde7d595bf32a3d94aa8af20a7863cf8e26933c989a42dfdae277bb2d7c2bbea3288c67b3fc383a72df86ad5892aa8a1205f6ffc3cfc92190b1f640ce4c0c139eb3fe0b00ce800cb004d4fe2178d764644c267f06000ca271c445e506d50000000049454e44ae426082");
            //			picDatas.put(
            //					"thumbsup_footerbar_goback_p",
            //					"89504e470d0a1a0a0000000d494844520000001e0000001e08030000000cee5e900000009f504c5445ffffff53535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535353535335a4f85a0000003474524e5300010203040506090a0b0f151935365d5f6972737e81878a8e8f919397999a9c9e9fa2a4a8a9acb4b5bdc5c6cccdd2d3ecedfcfe02e2eecd0000008949444154785ecdd1471282501444d1ff41111173c21c306156eefed76615f37e63eff4ccbadd5f15e56d436b27dea9d4f00833ad39acbdd26007fb40a9dfc02994ba844b24750e45ec5419dc9a5227f048a48ee1d572b261c9d360d7fd724f0cef955c63c3fb2545c3f0019c23c347d5a8ba6975896e012bafd96f2173baf0c02735bcbeefb8bfe80731e00dbbe6393e330000000049454e44ae426082");

            // picDatas.put(
            // "thumbsup_close",
            // "iVBORw0KGgoAAAANSUhEUgAAACAAAAAfCAYAAACGVs+MAAAABHNCSVQICAgIfAhkiAAAAo5JREFUSInFl79rE2EYxz9vQkKi3lXqUGjBlDYGOggtFcRJCDgUhBQphEADKZSCk+Lmdv+ARXQTnDp0cWqlIEihP4IZFKUdCqVSghpMwdD0SoOXK+dgUy7JJb17U+sz3T3vEz4fjvf95k5wUhoEu1V1BsuaAO4AQc63DOADQrwpHRy80v7eIwBmw+G+QCDw1rKs4XOGOpYQ4ku1Wr3/pFL5ITQIdivKR+DmRcBttVnS9Vv+B6r6EMhcMBygJxwK7fnHgsFnwPVatzce58bUFJf7+ihtbHRMiU5O0j8xgRACfXe3cVkVLxTlNycbTo1GubewgPD7Afg6P89nTZOGj2gag6kUANbxMe/Hxylvb9tHDB+23d4Vi53CAQZTKUYkBexwAOH3o0ajjWNBn/2umM1yVCjUTchINMIBjgoFitls02ydgFEus5rJUCkWpSWc4JVikdVMBqNcbi8AcJjPs5JOS0m0gq+k0xzm846/aRKQlZCBtxTwKiELbyvgVqITOIB4oSjWWUNXIhHuzs0R7ump6x/s7DQdLS9wOOMJ1KrVk+gU7lqgnUQncE8CNYm9XM5xbS+X8wz3LDCiaUQSCce1SCIhFduuBZx2e2PJxLYrgVZHbX16uqPYdiXQ7pz/XFuTjm1XAm5CppP/jrYCXhKuEwlHAZl4lZVoEhhIJqWzvZ3EQDLZUsCwN7qH6z8NvCZcK4lro6OO4z7gk73zfWnp9PqoUJCK15qE/fXu2+Ki0+imeKmqjyzLem7vdsViXB0aorC8TFXXPcHtFVAUeuNx9re2Gt+GARBCPP7vX0Y+DQzTNMeAzYuEm6Y5poHhB3hnmvptw3h9KRT6BYSB/n8EXhdCzJZ0feapae4D/AHqo5v2YwYmpQAAAABJRU5ErkJggg==");
            // picDatas.put("thumbsup_msg_finish", "");
        }
    }

    /** 判断是否含有指定名称的图像 */
    public static boolean Contains(String picName)
    {
        InitPics();

        if (picDatas.containsKey(picName))
            return true;
        else return false;
    }

    // 从数据创建Drawable
    @SuppressWarnings("deprecation")
    public static Drawable getDrawable(String picName)
    {
        InitPics();

        if (picDatas.containsKey(picName))
        {
            String data = picDatas.get(picName);					// 获取数据

            Bitmap bitmap = ToBitmap(data);
            BitmapDrawable pic = new BitmapDrawable(bitmap);

            return pic;
        }
        else return null;
    }

    private static Bitmap ToBitmap(String picData)
    {
        byte[] bytes = toBytes(picData);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        return bitmap;
    }

    /** 每两个字符还原为一个字节 */
    private static byte[] toBytes(String Hex)
    {
        byte[] B = new byte[Hex.length() / 2];
        for (int i = 0; i + 1 < Hex.length(); i += 2)
        {
            String hexStr = Hex.substring(i, i + 2);
            B[(i / 2)] = toByte(hexStr);
        }

        return B;
    }

    private static byte toByte(String Hex)
    {
        int N = ToInt(Hex.charAt(0)) * 16 + ToInt(Hex.charAt(1));
        return (byte) N;
    }

    private static int ToInt(char c)
    {
        if ('0' <= c && c <= '9')
            return (int) (c - '0');
        else if ('a' <= c && c <= 'z')
            return (int) (c - 'a' + 10);
        else return -1;
    }

    // ------------------
    // "thumbsup_close",
    // "iVBORw0KGgoAAAANSUhEUgAAACAAAAAfCAYAAACGVs+MAAAABHNCSVQICAgIfAhkiAAAAo5JREFUSInFl79rE2EYxz9vQkKi3lXqUGjBlDYGOggtFcRJCDgUhBQphEADKZSCk+Lmdv+ARXQTnDp0cWqlIEihP4IZFKUdCqVSghpMwdD0SoOXK+dgUy7JJb17U+sz3T3vEz4fjvf95k5wUhoEu1V1BsuaAO4AQc63DOADQrwpHRy80v7eIwBmw+G+QCDw1rKs4XOGOpYQ4ku1Wr3/pFL5ITQIdivKR+DmRcBttVnS9Vv+B6r6EMhcMBygJxwK7fnHgsFnwPVatzce58bUFJf7+ihtbHRMiU5O0j8xgRACfXe3cVkVLxTlNycbTo1GubewgPD7Afg6P89nTZOGj2gag6kUANbxMe/Hxylvb9tHDB+23d4Vi53CAQZTKUYkBexwAOH3o0ajjWNBn/2umM1yVCjUTchINMIBjgoFitls02ydgFEus5rJUCkWpSWc4JVikdVMBqNcbi8AcJjPs5JOS0m0gq+k0xzm846/aRKQlZCBtxTwKiELbyvgVqITOIB4oSjWWUNXIhHuzs0R7ump6x/s7DQdLS9wOOMJ1KrVk+gU7lqgnUQncE8CNYm9XM5xbS+X8wz3LDCiaUQSCce1SCIhFduuBZx2e2PJxLYrgVZHbX16uqPYdiXQ7pz/XFuTjm1XAm5CppP/jrYCXhKuEwlHAZl4lZVoEhhIJqWzvZ3EQDLZUsCwN7qH6z8NvCZcK4lro6OO4z7gk73zfWnp9PqoUJCK15qE/fXu2+Ki0+imeKmqjyzLem7vdsViXB0aorC8TFXXPcHtFVAUeuNx9re2Gt+GARBCPP7vX0Y+DQzTNMeAzYuEm6Y5poHhB3hnmvptw3h9KRT6BYSB/n8EXhdCzJZ0feapae4D/AHqo5v2YwYmpQAAAABJRU5ErkJggg==");

    // /** 图片转string */
    // public static String ToString(Bitmap bitmap)
    // {
    // ByteArrayOutputStream outStream = new ByteArrayOutputStream(); // outputstream
    // bitmap.compress(CompressFormat.PNG, 100, outStream); // 保存图像到输出流中
    // byte[] bytes = outStream.toByteArray(); // 转为byte数组
    // return Base64.encodeToString(bytes, Base64.DEFAULT); // Base64编码数组
    // }
    //
    // /** string数据转bitmap */
    // public static Bitmap ToBitmap(String bitmapData)
    // {
    // Bitmap bitmap = null;
    // try
    // {
    // // out = new FileOutputStream("/sdcard/aa.jpg");
    // byte[] bitmapArray = Base64.decode(bitmapData, Base64.DEFAULT);
    // bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
    // // bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
    // return bitmap;
    // }
    // catch (Exception e)
    // {
    // return null;
    // }
    // }

}
