package by.bsuir.timetable.desktop.controller;

public class StationsController {

    /*private TableView stationsView = new TableView();
    private Button searchStationButton = new Button("Поиск");
    private Label stationLabel = new Label("Станция");
    private TextField searchStationTextField = new TextField();
    private HBox searchHBox = new HBox(3);
    private TableColumn codeCol = new TableColumn();
    private TableColumn nameCol = new TableColumn();
    private TableColumn zoneCol = new TableColumn();
    private VBox vbox = new VBox(2);
    final private ObservableList<StationDto> stationObservableList = FXCollections.observableArrayList();
*/
    public static final String VIEW = "fxml/stations.fxml";


    /*@Autowired
    private StationService stationService;

    public void init(Tab stationsTab) {
        searchStationButton.setOnAction(event -> {
            List<StationDto> stations = stationService.findStationByNameLike(searchStationTextField.getText());
            stationObservableList.addAll(stations);
        });

        searchHBox.getChildren().addAll(stationLabel, searchStationTextField, searchStationButton);

        codeCol.setText("Код");
        codeCol.setCellValueFactory(new PropertyValueFactory("code"));
        nameCol.setText("Название");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        zoneCol.setText("Часовой пояс");
        zoneCol.setMinWidth(150);
        zoneCol.setCellValueFactory(new PropertyValueFactory("zone"));

        stationsView.getColumns().addAll(codeCol, nameCol, zoneCol);
        stationsView.setItems(stationObservableList);

        vbox.getChildren().addAll(searchHBox, stationsView);
        stationsTab.setContent(vbox);
    }*/
}
