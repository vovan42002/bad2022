package bad2022;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;


public class App {

	private JFrame frame;
	private JTextField text_min;
	private JTextField text_median;
	private JTextField text_average;
	private JTextField text_desc;
	private JTextField text_total_time;
	private JTextField text_max;
	private JTextField text_asc;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public App() {
		initialize();
	}

	// Визуальная часть

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 730, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);

		text_max = new JTextField();
		text_max.setBorder(new TitledBorder(null, "Max number", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_text_max = new GridBagConstraints();
		gbc_text_max.insets = new Insets(0, 0, 5, 0);
		gbc_text_max.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_max.gridx = 0;
		gbc_text_max.gridy = 2;
		frame.getContentPane().add(text_max, gbc_text_max);
		text_max.setColumns(10);

		text_min = new JTextField();
		text_min.setBorder(new TitledBorder(null, "Min number", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_text_min = new GridBagConstraints();
		gbc_text_min.insets = new Insets(0, 0, 5, 0);
		gbc_text_min.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_min.gridx = 0;
		gbc_text_min.gridy = 3;
		frame.getContentPane().add(text_min, gbc_text_min);
		text_min.setColumns(10);

		text_median = new JTextField();
		text_median.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Median", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_text_median = new GridBagConstraints();
		gbc_text_median.insets = new Insets(0, 0, 5, 0);
		gbc_text_median.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_median.gridx = 0;
		gbc_text_median.gridy = 4;
		frame.getContentPane().add(text_median, gbc_text_median);
		text_median.setColumns(10);

		text_average = new JTextField();
		text_average.setBorder(new TitledBorder(null, "Average", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_text_average = new GridBagConstraints();
		gbc_text_average.insets = new Insets(0, 0, 5, 0);
		gbc_text_average.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_average.gridx = 0;
		gbc_text_average.gridy = 5;
		frame.getContentPane().add(text_average, gbc_text_average);
		text_average.setColumns(10);

		text_asc = new JTextField();
		text_asc.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Asc max", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_text_asc = new GridBagConstraints();
		gbc_text_asc.insets = new Insets(0, 0, 5, 0);
		gbc_text_asc.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_asc.gridx = 0;
		gbc_text_asc.gridy = 6;
		frame.getContentPane().add(text_asc, gbc_text_asc);
		text_asc.setColumns(10);

		text_desc = new JTextField();
		text_desc.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Desc max", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_text_desc = new GridBagConstraints();
		gbc_text_desc.insets = new Insets(0, 0, 5, 0);
		gbc_text_desc.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_desc.gridx = 0;
		gbc_text_desc.gridy = 7;
		frame.getContentPane().add(text_desc, gbc_text_desc);
		text_desc.setColumns(10);

		text_total_time = new JTextField();
		text_total_time.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Total time", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_text_total_time = new GridBagConstraints();
		gbc_text_total_time.insets = new Insets(0, 0, 5, 0);
		gbc_text_total_time.fill = GridBagConstraints.HORIZONTAL;
		gbc_text_total_time.gridx = 0;
		gbc_text_total_time.gridy = 8;
		frame.getContentPane().add(text_total_time, gbc_text_total_time);
		text_total_time.setColumns(10);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenuItem mntmFile = new JMenuItem("Choose file");
		mntmFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getResults();
			}
		});
		menuBar.add(mntmFile);
	}

	//основной метод

	protected void getResults() {

		JFileChooser fileopen = new JFileChooser(); //для вызова окна выбора файла
		int ret = fileopen.showDialog(null, "Choose file"); //значение которое возвращает диалог выбора файла             
		if (ret == JFileChooser.APPROVE_OPTION) { //если выбраный файл можно открыть filopen
			File file = fileopen.getSelectedFile(); //заносим файл в переменную
			long startTime = System.currentTimeMillis(); //для подсчёта времени, начало
			try {
				BufferedReader in = new BufferedReader(new FileReader(file)); //буферизуем поток из файла
				String text;
				int counter = 0;
				BigDecimal sum = BigDecimal.ZERO;

				while ((text = in.readLine()) != null) { // читаємо файл по рядках
					sum = sum.add(new BigDecimal(text)); //сумуємо всі числа
					counter++; //считаем количество чисел
				}
				in.close();
				//рахуємо середнє арифметичне
				float average = sum.divide(BigDecimal.valueOf(counter),2, RoundingMode.CEILING).floatValue(); 
				in = new BufferedReader(new FileReader(file));
				int [] arr = new int[counter+1];
				int i = 0;
				while ((text = in.readLine()) != null) { // читаємо файл по рядках
					arr[i] = Integer.parseInt(text);     // заповнюємо масив числами з файлу
					i++;
				}
				in.close();

				List<Integer> asc = getAsc(arr); //список зростаючої послідовності
				List<Integer> desc = getDesc(arr); //список спадаючої послідовності

				arr = quickSort(arr, 0, counter); //сортируємо методом швидкого сортування
				
				int min= arr[0];
				int max= arr[arr.length-1];
				float median = getMedian(arr);

				//заносимо значення у візуальну частину
				text_max.setText(String.valueOf(max));
				text_min.setText(String.valueOf(min));
				text_average.setText(String.valueOf(average));
				text_asc.setText(asc.toString());
				text_desc.setText(desc.toString());
				text_median.setText(String.valueOf(median));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			long endTime = System.currentTimeMillis();
			text_total_time.setText(String.valueOf((endTime-startTime)/1000) + " seconds");
		}
	}

	public List<Integer> getAsc (int [] arr) {
		List<Integer> asc = new ArrayList<Integer>(); //для послідовності яка збільшується
		List<Integer> asc_final = new ArrayList<Integer>(); //фінальне значення
		for (int element : arr) {
			if (asc.size() == 0) { //якщо тільки почали
				asc.add(element); //заноcимо перше значення
			} else if (element > asc.get(asc.size()-1)) { //якщо більше остального в послідовності
				asc.add(element); //добавляем в конец
			} else {
				if (asc.size() > asc_final.size()) { //якщо дана послідовність більша за попередню
					asc_final = new ArrayList<Integer>(asc);
				}
				asc.clear();
				asc.add(element);
			}
		}
		return asc_final;
	}

	public List<Integer> getDesc (int [] arr) {
		List<Integer> desc = new ArrayList<Integer>(); // яка зменшується
		List<Integer> desc_final = new ArrayList<Integer>(); //фінальное значення
		for (int element : arr) {
			if (desc.size() == 0) { //якщо тільки почали
				desc.add(element); //заносимо перше значення
			} else if (element < desc.get(desc.size()-1)) { //якщо менше останнього в послідовності
				desc.add(element); //добавляем в конец
			} else {
				if (desc.size() > desc_final.size()) { //якщо дана послідовність більша за попередню
					desc_final = new ArrayList<Integer>(desc);
				}
				desc.clear();
				desc.add(element);
			}
		}
		return desc_final;
	}

	public float getMedian (int [] sortArr) {
		float median = 0;
		if (sortArr.length %2 == 0) { //якщо кількість елементів парна
			float left = sortArr[(sortArr.length/2)-1]; 
			float rigth = sortArr[sortArr.length/2];
			median = (left+rigth)/2;
		} else {  //якщо не парна
			median = sortArr[sortArr.length/2];
		}
		return median;
	}

	//швидке сортування
	public static int[] quickSort(int[] array, int low, int high) {
		if (array.length == 0)
			return array;//закінчити, якщо довжина масиву рівна 0

		if (low >= high)
			return array;//Закінчити якщо вже нема чого ділити

		// вибираємо опорний елемент
		int middle = low + (high - low) / 2;
		int opora = array[middle];

		// розділити на підмасиви, які більше та менше опорного елемента
		int i = low, j = high;
		while (i <= j) {
			while (array[i] < opora) {
				i++;
			}

			while (array[j] > opora) {
				j--;
			}

			if (i <= j) {//міняємо місцями
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}

		// Виклик рекурсії для сортування лівої та правої частини
		if (low < j)
			quickSort(array, low, j);

		if (high > i)
			quickSort(array, i, high);
		return array;
	}
}

