/*
 * 文 件 名:  ClientManager.java
 * 修 改 人:  chenchong@rong360.com
 * 修改时间:  2016年2月25日
 * 修改内容:  <修改内容>
 */
package learn.httpSender.test;

import learn.httpSender.test.DefaultRongClient;
/**
 *
 * @author  chenchong@rong360.com
 * @date  [2016年3月29日]
 */
public class ClientManager {

	public static RongClient createClient() {
		/** 测试环境时，请在hosts文件中添加：  59.151.86.29 openapi.rong360.com **/
		/**联调时，请机构修改为测试环境地址**/
		String url = "https://openapi.rong360.com/gateway";

		/** 融360开放平台分配的商户id 值与biz_data中merchant_id一样(注意修改CrawlerRequest中的merchantId的值) */
		/**请机构替换**/
		String appId = "3000002";
		/** 暂时只支持json返回格式 */
		String format = "json";
//
		/** 配置创建的RSA私钥   java的必须是pkcs8格式*/
		/**请机构替换**/
		String privateKey =
				"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANPKNNkvHFg9RWDg\n"
						+ "lkZy96XiRiP2dZIRSDJRL2gMi4iFVhlwdvltKus3E4R3vhNNwQJpcuiJP0KYSaHy\n"
						+ "d8C2RNcp/dr7XZrCP3MmhbC8FpSAPpDbWzDh34LYxn8Gwkk+GXq3csJ5+VszyNQy\n"
						+ "LkjQ/V+5A6CBMjjMlOk0NU6wazO5AgMBAAECgYAqN7yhLorv7AbQcPSDxpcnMhvZ\n"
						+ "P1/gZiGGJjjU/Oszo6CuIYUV43USvj/dwCDbqDw5RtvpDrLVi5Xh+nt0puDBxm/5\n"
						+ "BcaEhZ/wZO0BsUO3td7irrabxvdOZXXhePf0CNHy7WYe9gQOOdVkJRsn18SYjgFJ\n"
						+ "5J5DGETF9wtqrI9CgQJBAPGS8kwEQwN1BG6eAofetEr3mlr0+NfnmoKDtKTjWB0n\n"
						+ "CB/lQQ2AnV0+db3+i3rVjViiTcXoqw1Ovk597N8V4G0CQQDgb++gdxVaDyKXWTTm\n"
						+ "g0LwpBJL2258CLu4yIiQFs9AfyaSrCV6NT+upqBnWGbmm4Jf363aozrYrEHeAfgo\n"
						+ "TQj9AkBC8ValjBTJ83Zr9Ot8nVFW6PBkPjhrFCoz+q1nd/yl73gH5q61QCvbeACG\n"
						+ "yu/59Q27PxbQPh6QjH6eH7UxSM2tAkBAnlna1I50OIlYFBoUCFTcnhCagJol4gnS\n"
						+ "YQJYogiX5EQB1MiRkAU+zsC+IIi3+qwl2Gvg2EBYI/hu6Bg/2jYtAkEA6YApkkdB\n"
						+ "sZmeRprs9ZQAZShMBj06EuK6mFdoJpIatZOxPxw/R12MT4IbdD232ajpxOAViFVI\n"
						+"GhocDo0Q3YRDYg==";

		return new DefaultRongClient(url, appId, privateKey, format, "utf-8");
	}

}