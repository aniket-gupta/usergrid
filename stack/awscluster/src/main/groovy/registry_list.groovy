/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  The ASF licenses this file to You
 * under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.  For additional information regarding
 * copyright in this work, please see the NOTICE file in the top level
 * directory of this distribution.
 */


// 
// registry_list.groovy 
// 
// List contents of registry as debugging aid. Not used in any other scripts. 
//
import com.amazonaws.auth.*
import com.amazonaws.services.simpledb.*
import com.amazonaws.services.simpledb.model.*

String accessKey = (String)System.getenv().get("AWS_ACCESS_KEY")
String secretKey = (String)System.getenv().get("AWS_SECRET_KEY")
String stackName = (String)System.getenv().get("STACK_NAME")
String hostName  = (String)System.getenv().get("PUBLIC_HOSTNAME")
String domain    = stackName

def creds = new BasicAWSCredentials(accessKey, secretKey)
def sdbClient = new AmazonSimpleDBClient(creds)

def selectResult = sdbClient.select(new SelectRequest((String)"select * from ${domain}"))

for (item in selectResult.getItems()) {
    def att = item.getAttributes().get(0)
    println "${item.getName()} -> ${att.getName()} : ${att.getValue()}"
}
