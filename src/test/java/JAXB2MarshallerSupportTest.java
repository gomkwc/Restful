import junit.framework.Assert;

import org.junit.Test;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.google.bean.Fruit;

public class JAXB2MarshallerSupportTest {
	@Test
	public void fruitClassShouldBeSupported() {
		// given
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(new Class<?>[] { Fruit.class });

		// when
		boolean fruitSupported = marshaller.supports(Fruit.class);

		// then
		Assert.assertEquals(fruitSupported, true);
	}
}
