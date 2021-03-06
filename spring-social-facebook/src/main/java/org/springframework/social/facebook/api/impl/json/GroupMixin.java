/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.facebook.api.impl.json;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.springframework.social.facebook.api.Group.Privacy;
import org.springframework.social.facebook.api.Reference;

/**
 * Annotated mixin to add Jackson annotations to Group. 
 * @author Craig Walls
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class GroupMixin {
	
	@JsonCreator
	GroupMixin(
			@JsonProperty("id") String id, 
			@JsonProperty("owner") Reference owner, 
			@JsonProperty("name") String name, 
			@JsonProperty("privacy") @JsonDeserialize(using = PrivacyDeserializer.class) Privacy privacy, 
			@JsonProperty("icon") String icon, 
			@JsonProperty("updated_time") Date updatedTime, 
			@JsonProperty("email") String email) {}
	
	@JsonProperty("description")
	String description;
	
	private static class PrivacyDeserializer extends JsonDeserializer<Privacy> {
		@Override
		public Privacy deserialize(JsonParser jp, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			return Privacy.valueOf(jp.getText().toUpperCase());
		}
	}
}
