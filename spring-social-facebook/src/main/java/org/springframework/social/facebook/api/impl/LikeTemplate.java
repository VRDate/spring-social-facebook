/*
 * Copyright 2011 the original author or authors.
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
package org.springframework.social.facebook.api.impl;

import java.util.List;

import org.springframework.social.facebook.api.GraphApi;
import org.springframework.social.facebook.api.LikeOperations;
import org.springframework.social.facebook.api.UserLike;
import org.springframework.util.LinkedMultiValueMap;

class LikeTemplate extends AbstractFacebookOperations implements LikeOperations {

	private final GraphApi graphApi;

	public LikeTemplate(GraphApi graphApi, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.graphApi = graphApi;
	}

	public void like(String objectId) {
		requireAuthorization();
		graphApi.post(objectId, "likes", new LinkedMultiValueMap<String, String>());
	}

	public void unlike(String objectId) {
		requireAuthorization();
		graphApi.delete(objectId, "likes");
	}

	public List<UserLike> getLikes() {
		return getLikes("me");
	}

	public List<UserLike> getLikes(String userId) {
		requireAuthorization();
		return graphApi.fetchConnections(userId, "likes", UserLike.class);
	}
	
	public List<UserLike> getBooks() {
		return getBooks("me");
	}

	public List<UserLike> getBooks(String userId) {
		requireAuthorization();
		return graphApi.fetchConnections(userId, "books", UserLike.class);
	}

	public List<UserLike> getMovies() {
		return getMovies("me");
	}

	public List<UserLike> getMovies(String userId) {
		requireAuthorization();
		return graphApi.fetchConnections(userId, "movies", UserLike.class);
	}

	public List<UserLike> getMusic() {
		return getMusic("me");
	}

	public List<UserLike> getMusic(String userId) {
		requireAuthorization();
		return graphApi.fetchConnections(userId, "music", UserLike.class);
	}

	public List<UserLike> getTelevision() {
		return getTelevision("me");
	}

	public List<UserLike> getTelevision(String userId) {
		requireAuthorization();
		return graphApi.fetchConnections(userId, "television", UserLike.class);
	}

	public List<UserLike> getActivities() {
		return getActivities("me");
	}

	public List<UserLike> getActivities(String userId) {
		requireAuthorization();
		return graphApi.fetchConnections(userId, "activities", UserLike.class);
	}

	public List<UserLike> getInterests() {
		return getInterests("me");
	}

	public List<UserLike> getInterests(String userId) {
		requireAuthorization();
		return graphApi.fetchConnections(userId, "interests", UserLike.class);
	}
}
