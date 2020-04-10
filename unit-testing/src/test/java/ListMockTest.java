

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
public class ListMockTest {

	List<String> mockList = mock(List.class);
	@Test
	public void testListSize() {
		
	
		when(mockList.size()).thenReturn(5);
		
		assertEquals(5, mockList.size());
	}
	
	@Test
	public void testListReturnDiffValues() {
		
		
		when(mockList.size()).thenReturn(5).thenReturn(10);
		
		assertEquals(5, mockList.size());
		assertEquals(10, mockList.size());
	}
	
	@Test
	public void returnWithParamter() {
		when(mockList.get(0)).thenReturn("testing");
		
		assertEquals("testing", mockList.get(0));
		//other index it will return default value.
		assertEquals(null, mockList.get(1));
	
	}

	@Test
	public void returnWithGenericParamters() {
		when(mockList.get(anyInt())).thenReturn("testing");
		
		assertEquals("testing", mockList.get(0));
		//other index it will return default value.
		assertEquals("testing", mockList.get(1));
	
	}
	
	@Test
	public void verificationBasics() {
		String s1 = mockList.get(0);
		String s2 = mockList.get(1);
	
		verify(mockList).get(0);
		verify(mockList,atLeastOnce()).get(anyInt());
		verify(mockList,atMost(2)).get(anyInt());
		verify(mockList,never()).get(2);
		
	}
	
	@Test
	public void argumentCapture() {
		mockList.add("SomeString");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		verify(mockList).add(captor.capture());
		
		assertEquals("SomeString",captor.getValue());
	}
	
	@Test
	public void multipleArgumentCapture() {
		mockList.add("SomeString1");
		mockList.add("SomeString2");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		verify(mockList,atLeastOnce()).add(captor.capture());
		
		assertEquals("SomeString1",captor.getAllValues().get(0));
		assertEquals("SomeString2",captor.getAllValues().get(1));
	}
	
	@Test
	public void mocking() {
		ArrayList list = mock(ArrayList.class);
		
		list.get(0);//null
		list.size();//0
		list.add("A");
		list.add("B");
		list.size();//0
		
		when(list.size()).thenReturn(5);
		list.size();//5
	}
	
	@Test
	public void spying() {
		ArrayList list = spy(ArrayList.class);
		
		//list.get(0);//Exception 
		list.size();//0
		list.add("A");
		list.add("B");
		list.size();//2

		System.out.println(list.size());
		when(list.size()).thenReturn(5);
		System.out.println(list.size());//5
		
		list.add("C");
		System.out.println(list.size());//5 Reason it will be overridden
	}
}
