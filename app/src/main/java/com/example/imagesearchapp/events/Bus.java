/*
 * *
 *  * Created by Shweta Pandey on 8/10/19 10:29 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 8/10/19 10:29 PM
 *
 */

package com.example.imagesearchapp.events;

import org.greenrobot.eventbus.EventBus;

public class Bus {
	private static EventBus bus;
	public static EventBus getBus(){
		if(bus == null){
			bus = EventBus.getDefault();

		}
		return bus;
	}
}
