package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HelloGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float x, y, xv, yv;

	static final float MAX_VELOCITY = 100;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		move();

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}

	float decelerate(float velocity){
		float deceleration = 0.99f;
		velocity *= deceleration;
		if (Math.abs(velocity) < 1){
			velocity = 0;
		}
		return velocity;
	}

	void move(){
		if (Gdx.input.isKeyPressed(Input.Keys.UP)){
			yv = MAX_VELOCITY;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			yv = -1*MAX_VELOCITY;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			xv = -1*MAX_VELOCITY;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			xv = MAX_VELOCITY;
		}

		y += yv*Gdx.graphics.getDeltaTime();
		x += xv*Gdx.graphics.getDeltaTime();

		yv = decelerate(yv);
		xv = decelerate(xv);

	}

}
