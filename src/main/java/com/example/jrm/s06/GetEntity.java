package com.example.jrm.s06;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetEntity {
	public static void main(String[] args) {
		SessionFactory sf = HibUtil.getSessionFactory();
		Session session = sf.openSession();

		// Region.class prendi un reference all'oggetto che mi rappresenta la classe
		// Region. Ovvero voglio lavorare con un oggetto di classe Region
		Region europe = session.get(Region.class, 42);
		System.out.println(europe);

		session.close();

		// just a single SF is usually used in an application
		sf.close();
	}
}
