/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cogni.core;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author ADMINIBM
 */
public class MyService {
    
    public String CallRRService( String error) throws Exception{
       String res = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httpPost = new HttpPost("https://a0319e47-dd55-49c6-b718-07f18ab92e0c:SYLem5HoMVBv@gateway.watsonplatform.net/retrieve-and-rank/api/v1/solr_clusters/sc52fc10f5_442e_4a9c_b771_eade20d72284/solr/cognitivesupportassistant/fcselect?");
            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
            //nvps.add(new BasicNameValuePair("username", "6a1787d3-4427-4397-9016-c08f5ca285d9"));
            //nvps.add(new BasicNameValuePair("password", "tqJMu4VtB6Se"));
            //nvps.add(new BasicNameValuePair("solr_cluster_ID", "sccdd7250e_375c_41b6_aec1_8493851f91f3"));
            //nvps.add(new BasicNameValuePair("example_collection", "cognitivesupportassistant"));
            nvps.add(new BasicNameValuePair("ranker_id", "766366x22-rank-600"));
            nvps.add(new BasicNameValuePair("q", error));
            nvps.add(new BasicNameValuePair("wt", "jason"));
            nvps.add(new BasicNameValuePair("fl", "body"));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            CloseableHttpResponse response2 = httpclient.execute(httpPost);

            try {
                System.out.println(response2.getStatusLine());
                
               // HttpEntity entity2 = response2.getEntity();
               
                BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response2.getEntity().getContent()));

                StringBuffer result = new StringBuffer();
                String line = "";
                while ((line = rd.readLine()) != null) {
                        result.append(line);
                }
                res = result.toString();
                System.err.println(result.toString());
                
              //  EntityUtils.consume(entity2);
                
            } finally {
                response2.close();
            }
        } finally {
            httpclient.close();
        } 
        return res;
    }
        
}
