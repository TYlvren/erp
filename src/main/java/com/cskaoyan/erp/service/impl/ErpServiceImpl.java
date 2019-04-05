package com.cskaoyan.erp.service.impl;


import com.cskaoyan.erp.dao.*;
import com.cskaoyan.erp.model.*;

import com.cskaoyan.erp.dao.DeviceMaintainDao;
import com.cskaoyan.erp.dao.UnQualifyApplyDao;
import com.cskaoyan.erp.model.DeviceMaintain;
import com.cskaoyan.erp.model.UnQualifyApply;

import com.cskaoyan.erp.service.ErpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("erpService")
public class ErpServiceImpl implements ErpService {


    /*****************计划进度接口实现*************************************/
    @Autowired
    private COrderDao cOrderDao;


    @Autowired
    private CustomDao customDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private WorkDao workDao;

    @Autowired
    private ManufactureDao manufactureDao;

    @Autowired
    private TaskDao taskDao;

    /**------------------------------Order--------------------------------*/

    /**
     * 查询订单API的实现
     *
     * @return
     * @see { ErpService }
     */
    @Override
    public List<COrder> findCOrder() {
        return cOrderDao.selectALLCOder();
    }

    @Override
    public List<COrder> findCOrderBySearch(String condition, String searchValue) {
        return cOrderDao.selectCOderBySearch(condition, searchValue);
    }

    @Override
    public COrder findCOrderById(String id) {
        return cOrderDao.selectCOrderById(id);
    }

    @Override
    public int addOrder(COrder cOrder) {
        return cOrderDao.insertOrder(cOrder);
    }

    @Override
    public int editOrder(COrder cOrder) {
        return cOrderDao.updateOrder(cOrder);
    }

    @Override
    public int deleteOrder(String[] ids) {
        return cOrderDao.deleteOrderByIds(ids);
    }

    /**
     * ------------------------------Custom--------------------------------
     */
    @Override
    public List<Custom> findCustom() {
        return customDao.selectAllCustom();
    }

    @Override
    public Custom findCustomById(String id) {
        return customDao.selectCustomById(id);
    }

    @Override
    public List<COrder> findCustomBySearch(String condition, String searchValue) {
        return customDao.selectCustomBySearch(condition, searchValue);
    }

    @Override
    public int addCustom(Custom custom) {
        return customDao.insertCustom(custom);
    }

    @Override
    public int editCustom(Custom custom) {
        return customDao.updateCustom(custom);
    }

    @Override
    public int deleteCustom(String[] ids) {
        return customDao.deleteCustomByIds(ids);
    }

    /**
     * ------------------------------Product--------------------------------
     */
    @Override
    public List<Product> findProduct() {
        return productDao.selectAllProduct();
    }

    @Override
    public List<Product> findProductBySearch(String condition, String searchValue) {
        return productDao.selectProductBySearch(condition, searchValue);
    }

    @Override
    public Product findProductById(String id) {
        return productDao.selectProductById(id);
    }

    @Override
    public int addProduct(Product product) {
        return productDao.insertProduct(product);
    }

    @Override
    public int editProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public int deleteProduct(String[] ids) {
        return productDao.deleteProductById(ids);
    }

    /**
     * ------------------------------Work--------------------------------
     */
    @Override
    public List<Work> findWork() {
        return workDao.selectAllWork();
    }

    @Override
    public List<Work> findWorkBySearch(String condition, String searchValue) {
        return workDao.selectWorkBySearch(condition, searchValue);
    }

    @Override
    public Work findWorkById(String id) {
        return workDao.selectWorkById(id);
    }

    @Override
    public int addWork(Work work) {
        return workDao.insertWork(work);
    }

    @Override
    public int editWork(Work work) {
        return workDao.updateWork(work);
    }

    @Override
    public int deleteWork(String[] ids) {
        return workDao.deleteWorkByIds(ids);
    }

    /**
     * ------------------------------Manufacture--------------------------------
     */

    @Override
    public List<Manufacture> findManufacture() {
        return manufactureDao.selectAllManufacture();
    }

    @Override
    public List<Manufacture> findManufactureBySearch(String condition, String searchValue) {
        return manufactureDao.selectManufactureBySearch(condition, searchValue);
    }

    @Override
    public Manufacture findManufactureById(String id) {
        return manufactureDao.selectManufactureById(id);
    }

    @Override
    public int addManufacture(Manufacture manufacture) {
        return manufactureDao.insertManufacture(manufacture);
    }

    @Override
    public int editManufacture(Manufacture manufacture) {
        return manufactureDao.updateManufacture(manufacture);
    }

    @Override
    public int deleteManufacture(String[] ids) {
        return manufactureDao.deleteManufactureByIds(ids);
    }

    /**
     * ------------------------------Task--------------------------------
     */
    @Override
    public List<Task> findTask() {
        return taskDao.selectAllTask();
    }

    @Override
    public List<Task> findTaskBySearch(String condition, String searchValue) {
        return taskDao.selectTaskBySearch(condition, searchValue);
    }

    @Override
    public Task findTaskById(String id) {
        return taskDao.selectTaskById(id);
    }

    @Override
    public int addTask(Task task) {
        return taskDao.insertTask(task);
    }

    @Override
    public int editTask(Task task) {
        return taskDao.updateTask(task);
    }

    @Override
    public int deleteTask(String[] ids) {
        return taskDao.deleteTaskByIds(ids);
    }

    /*****************设备管理接口实现*************************************/
    @Autowired
    DeviceMaintainDao deviceMaintainDao;
    @Autowired
    DeviceTypeDao deviceTypeDao;
    @Autowired
    DeviceFaultDao deviceFaultDao;
    @Autowired
    DeviceDao deviceDao;
    @Autowired
    DeviceCheckDao deviceCheckDao;

    /*-------------设备分类模块------------------------------------------------*/

    @Override
    public List<DeviceType> findDeviceTypeByPage() {
        return deviceTypeDao.findAllDeviceType();
    }

    @Override
    public int insertDeviceType(DeviceType deviceType) {
        return deviceTypeDao.insertDeviceType(deviceType);
    }

    @Override
    public int updateDeviceType(DeviceType deviceType) {
        return deviceTypeDao.modifyDeviceTypeById(deviceType);
    }

    @Override
    public int deleteDeviceType(String id) {
        return deviceTypeDao.deleteDeviceTypeById(id);
    }

    @Override
    public List<DeviceType> findDeviceTypeById(String searchValue) {
        return deviceTypeDao.findDeviceTypeById(searchValue);
    }

    @Override
    public DeviceType getDeviceTypeById(String id) {
        return deviceTypeDao.getDeviceTypeById(id);
    }

    @Override
    public List<DeviceType> findDeviceTypeByName(String searchValue) {
        return deviceTypeDao.findDeviceTypeByName(searchValue);
    }


    /*-------------设备模块----------------------------------------------------*/
    @Override
    public List<Device> findDeviceByPage() {
        return deviceDao.findAllDevice();
    }

    @Override
    public int insertDevice(Device device) {
        return deviceDao.insertDevice(device);
    }

    @Override
    public int updateDevice(Device device) {
        return deviceDao.updateDeviceById(device);
    }

    @Override
    public int deleteDevice(String id) {
        return deviceDao.deleteDeviceById(id);
    }

    @Override
    public List<Device> findDeviceById(String searchValue) {
        return deviceDao.findDeviceById(searchValue);
    }

    @Override
    public Device findServiceDeviceById(String id) {
        return deviceDao.findServiceDeviceById(id);
    }

    @Override
    public List<Device> findDeviceByName(String searchValue) {
        return deviceDao.findDeviceByName(searchValue);
    }

    @Override
    public int updateDeviceNote(Device device) {
        return deviceDao.updateDeviceNote(device);
    }

    @Override
    public List<Device> findDeviceByTypeName(String searchValue) {
        return deviceDao.findDeviceByTypeName(searchValue);
    }


    /*-------------设备例检模块------------------------------------------------*/
    @Override
    public List<DeviceCheck> findDeviceeCheckByPage() {
        return deviceCheckDao.findAllDeviceCheck();
    }

    @Override
    public int insertDeviceCheck(DeviceCheck deviceCheck) {
        return deviceCheckDao.insertDeviceCheck(deviceCheck);
    }

    @Override
    public int updateDeviceCheck(DeviceCheck deviceCheck) {
        return deviceCheckDao.updateDeviceCheck(deviceCheck);
    }

    @Override
    public int deleteDeviceCheck(String id) {
        return deviceCheckDao.deleteDeviceCheck(id);
    }

    @Override
    public List<DeviceCheck> findDeviceCheckById(String searchValue) {
        return deviceCheckDao.findDeviceCheckById(searchValue);
    }

    @Override
    public DeviceCheck getDeviceCheckById(String id) {
        return deviceCheckDao.getDeviceCheckById(id);
    }

    @Override
    public List<DeviceCheck> findDeviceCheckByName(String searchValue) {
        return deviceCheckDao.getDeviceCheckByName(searchValue);
    }

    @Override
    public int updateDeviceCheckNote(DeviceCheck deviceCheck) {
        return deviceCheckDao.updateDeviceCheckByNote(deviceCheck);
    }

    /*-------------设备故障模块------------------------------------------------*/
    @Override
    public List<DeviceFault> findAllDeviceFaultByPage() {
        return deviceFaultDao.findAllDeviceFault();
    }

    @Override
    public int insertDeviceFault(DeviceFault deviceFault) {
        return deviceFaultDao.insertDeviceFault(deviceFault);
    }

    @Override
    public int updateDeviceFault(DeviceFault deviceFault) {
        return deviceFaultDao.updateDeviceFault(deviceFault);
    }

    @Override
    public int deleteDeviceFault(String id) {
        return deviceFaultDao.deleteDeviceFault(id);
    }

    @Override
    public List<DeviceFault> findDeviceFaultById(String searchValue) {
        return deviceFaultDao.findDeviceFaultById(searchValue);
    }

    @Override
    public DeviceFault getDeviceFaultById(String searchValue) {
        return deviceFaultDao.getDeviceFaultById(searchValue);
    }

    @Override
    public List<DeviceFault> findDeviceFaultByName(String searchValue) {
        return deviceFaultDao.findDeviceFaultByName(searchValue);
    }

    @Override
    public int updateDeviceFaultNote(DeviceFault deviceFault) {
        return deviceFaultDao.updateDeviceFaultNote(deviceFault);
    }

    /*-------------设备维修模块------------------------------------------------*/
    @Override
    public List<DeviceMaintain> findDeviceMaintainByPage() {
        return deviceMaintainDao.findAllDeviceMaintain();
    }

    @Override
    public int insertDeviceMaintain(DeviceMaintain deviceMaintain) {
        return deviceMaintainDao.insertDeviceMaintain(deviceMaintain);
    }

    @Override
    public int updateDeviceMaintain(DeviceMaintain deviceMaintain) {
        return deviceMaintainDao.updateDeviceMaintain(deviceMaintain);
    }

    @Override
    public int deleteDeviceMaintain(String id) {
        return deviceMaintainDao.deleteDeviceMaintain(id);
    }

    @Override
    public List<DeviceMaintain> findDeviceMaintainById(String searchValue) {
        return deviceMaintainDao.findDeviceMaintainById(searchValue);
    }

    @Override
    public List<DeviceMaintain> findDeviceMaintainByFaultId(String searchValue) {
        return deviceMaintainDao.findDeviceMaintainByFaultId(searchValue);
    }

    @Override
    public int updateDeviceMaintainNote(DeviceMaintain deviceMaintain) {
        return deviceMaintainDao.updateDeviceMaintainNote(deviceMaintain);
    }


    /*****************工艺监控接口实现*************************************/


    /*****************物料监控接口实现*************************************/
    /*-------------物料信息模块------------------------------------------------*/
    @Autowired
    private MaterialDao materialDao;
    @Autowired
    private MaterialReceiveDao materialReceiveDao;
    @Autowired
    private MaterialConsumeDao materialConsumeDao;

    @Override
    public List<Material> selectMaterial() {
        return materialDao.selectMaterial();
    }

    @Override
    public int selectCountOfMaterial() {
        return materialDao.count();
    }

    @Override
    public int removeMaterialById(String id) {
        return materialDao.deleteById(id);
    }

    @Override
    public int modifyMaterial(Material material) {
        return materialDao.update(material);
    }

    @Override
    public int addMaterial(Material material) {
        return materialDao.addMaterial(material);
    }

    @Override
    public List<Material> selectMaterialById(String searchValue) {
        return materialDao.selectByID(searchValue);
    }

    @Override
    public List<Material> selectMaterialByType(String searchValue) {
        return materialDao.selectByType(searchValue);
    }


    @Override
    public int modifyNote(Material material) {
        return materialDao.updateNote(material);
    }


    /*-------------物料收入模块------------------------------------------------*/
    @Override
    public Map<String, Object> listMaterialReceiveByPage(Integer pageNum, Integer pageSize) {
        Integer num = pageNum != null ? pageNum : 1;
        Integer size = pageSize != null ? pageSize : 10;
        Page onePage = PageHelper.startPage(num, size, true);

        Map<String, Object> map = new HashMap<>();
        List<MaterialReceive> materials = materialReceiveDao.selectAll();
        map.put("total", onePage.getTotal());
        map.put("rows", materials);
        return map;
    }

    @Override
    public Map<String, Object> searchMaterialReceiveBymaterialId(String materialId, Integer pageNum, Integer pageSize) {
        Integer num = pageNum != null ? pageNum : 1;
        Integer size = pageSize != null ? pageSize : 10;
        Page onePage = PageHelper.startPage(num, size, true);

        Map<String, Object> map = new HashMap<>();
        List<MaterialReceive> materialReceives = materialReceiveDao.selectLikeMaterialId(materialId);
        map.put("total", onePage.getTotal());
        map.put("rows", materialReceives);
        return map;
    }

    @Override
    public Map<String, Object> searchMaterialReceiveByReceiveId(String receiveId, Integer pageNum, Integer pageSize) {
        Integer num = pageNum != null ? pageNum : 1;
        Integer size = pageSize != null ? pageSize : 10;
        Page onePage = PageHelper.startPage(num, size, true);

        Map<String, Object> map = new HashMap<>();
        List<MaterialReceive> materialReceives = materialReceiveDao.selectLikeReceiveId(receiveId);
        map.put("total", onePage.getTotal());
        map.put("rows", materialReceives);
        return map;

    }

    @Override
    public int removeMaterialReceiveById(String id) {
        return materialReceiveDao.deleteById(id);
    }

    @Override
    public int modifyMaterialReceive(MaterialReceive materialReceive) {
        return materialReceiveDao.updateReceive(materialReceive);
    }

    @Override
    public int addMaterialReceive(MaterialReceive materialReceive) {
        return materialReceiveDao.addMaterialReceive(materialReceive);
    }

    @Override
    public List<Material> selectMaterialId() {
        return materialReceiveDao.selectMaterialId();
    }

    @Override
    public int modifyReceiveNote(MaterialReceive materialReceive) {
        return materialReceiveDao.updateReceiveNote(materialReceive);
    }

    /*-------------物料消耗模块------------------------------------------------*/
    @Override
    public int removeMaterialConsumeById(String id) {
        return materialConsumeDao.deleteById(id);
    }

    @Override
    public int modifyMaterialConsume(MaterialConsume materialConsume) {
        return materialConsumeDao.updateConsume(materialConsume);
    }

    @Override
    public int addMaterialConsume(MaterialConsume materialConsume) {
        return materialConsumeDao.addMaterialConsume(materialConsume);
    }

    @Override
    public int modifyConsumeNote(MaterialConsume materialConsume) {
        return materialConsumeDao.updateConsumeNote(materialConsume);
    }

    @Override
    public Map<String, Object> listMaterialConsumeByPage(Integer pageNum, Integer pageSize) {
        Integer num = pageNum != null ? pageNum : 1;
        Integer size = pageSize != null ? pageSize : 10;
        Page onePage = PageHelper.startPage(num, size, true);

        Map<String, Object> map = new HashMap<>();
        List<MaterialConsume> materials = materialConsumeDao.selectAll();
        map.put("total", onePage.getTotal());
        map.put("rows", materials);
        return map;
    }

    @Override
    public Map<String, Object> searchMaterialConsumeBymaterialId(String materialId, Integer pageNum, Integer pageSize) {
        Integer num = pageNum != null ? pageNum : 1;
        Integer size = pageSize != null ? pageSize : 10;
        Page onePage = PageHelper.startPage(num, size, true);

        Map<String, Object> map = new HashMap<>();
        List<MaterialConsume> materialConsumes = materialConsumeDao.selectLikeMaterialId(materialId);
        map.put("total", onePage.getTotal());
        map.put("rows", materialConsumes);
        return map;

    }

    @Override
    public Map<String, Object> searchMaterialConsumeByWorkId(String workId, Integer pageNum, Integer pageSize) {
        Integer num = pageNum != null ? pageNum : 1;
        Integer size = pageSize != null ? pageSize : 10;
        Page onePage = PageHelper.startPage(num, size, true);

        Map<String, Object> map = new HashMap<>();
        List<MaterialConsume> materialConsumes = materialConsumeDao.selectLikeWorkId(workId);
        map.put("total", onePage.getTotal());
        map.put("rows", materialConsumes);
        return map;

    }

    @Override
    public Map<String, Object> searchMaterialConsumeByConsumeId(String consumeId, Integer pageNum, Integer pageSize) {
        Integer num = pageNum != null ? pageNum : 1;
        Integer size = pageSize != null ? pageSize : 10;
        Page onePage = PageHelper.startPage(num, size, true);

        Map<String, Object> map = new HashMap<>();
        List<MaterialConsume> materialConsumes = materialConsumeDao.selectLikeConsumeId(consumeId);
        map.put("total", onePage.getTotal());
        map.put("rows", materialConsumes);
        return map;

    }

    /*****************质量监控接口实现*************************************/
//    ------------------不合格品管理-------------------
    //**********注入Dao
    @Autowired
    private UnQualifyApplyDao unQualifyApplyDao;

    //***********查询不合格品
    @Override
    public List<UnQualifyApply> findUnqualifyList() {

        List<UnQualifyApply> unqualifyListDao = unQualifyApplyDao.findUnqualifyListDao();
        return unqualifyListDao;
    }

    //************新建不合格品
    @Override
    public int addUnqualifyService(UnQualifyApply unQualifyApply) {
        return unQualifyApplyDao.addUnqualifyDao(unQualifyApply);
    }
    //***********修改不合格品

    @Override
    public int updateUnqualifyService(UnQualifyApply unQualifyApply) {
        return unQualifyApplyDao.updateUnqualifyDao(unQualifyApply);
    }

    //**********删除不合格品(可为多条)
    @Override
    public int deleteUnqualifyService(String[] ids) {
        return unQualifyApplyDao.deleteUnqualifyDao(ids);
    }

    //*************修改不合格品备注功能
    @Override
    public int updateNoteUnqualifyService(String unqualifyApplyId, String note) {
        return unQualifyApplyDao.updateNoteByUnqualifyApplyIdDao(unqualifyApplyId, note);
    }
//    //***********模糊查询

    @Override
    public List<UnQualifyApply> searchUnqualifyService(String searchname, String searchValue) {
        return unQualifyApplyDao.searchUnqualifyDao(searchname, searchValue);
    }

    //-------------------------成品计量质检--------------------------------------
    //************注入Dao
    @Autowired
    private FinalMeasureCheckDao finalMeasureCheckDao;

    //***********查询产品计量质检列表
    @Override
    public List<FinalMeasureCheck> findFMeasureCheck() {
        return finalMeasureCheckDao.findFMeasureCheckDao();
    }

    //**********添加成品计量质检记录
    @Override
    public int addFMeasureCheckService(FinalMeasureCheck finalMeasureCheck) {
        return finalMeasureCheckDao.insertFMeasureCheckDao(finalMeasureCheck);
    }

    //**********修改成品计量质检记录
    @Override
    public int updateFMeasureCheckService(FinalMeasureCheck finalMeasureCheck) {
        return finalMeasureCheckDao.updateFMeasureCheckDao(finalMeasureCheck);
    }

    //*********删除成品计量质检记录
    @Override
    public int deleteFMeasureCheckService(String[] ids) {
        return finalMeasureCheckDao.deleteFMeasureCheckDao(ids);
    }

    //***********修改备注成品计量质检记录
    @Override
    public int updateNoteFMeasureCheckService(String fMeasureCheckId, String note) {
        return finalMeasureCheckDao.updateNoteFMeasureCheckDao(fMeasureCheckId, note);
    }

    //**************查找*********
    @Override
    public List<FinalMeasureCheck> searchFMeasureCheckService(String searchname, String searchValue) {
        return finalMeasureCheckDao.searchFMeasureCheckDao(searchname, searchValue);
    }

    //-------------------------成品计数质检--------------------------------------
    //************注入Dao
    @Autowired
    private FinalCountCheckDao finalCountCheckDao;
    //***********查询成品计数质检列表

    @Override
    public List<FinalCountCheck> findFCountCheck() {
        return finalCountCheckDao.findFCountCheckDao();
    }

    //**********添加成品计数质检记录

    @Override
    public int addFCountCheckService(FinalCountCheck finalCountCheck) {
        return finalCountCheckDao.insertFCountCheckDao(finalCountCheck);
    }
//    //**********修改成品计数质检记录

    @Override
    public int updateFCountCheckService(FinalCountCheck finalCountCheck) {
        return finalCountCheckDao.updateFCountCheckDao(finalCountCheck);
    }

//    //*********删除成品计数质检记录

    @Override
    public int deleteFCountCheckService(String[] ids) {
        return finalCountCheckDao.deleteFCountCheckDao(ids);
    }

//    //***********修改备注成品计数质检记录

    @Override
    public int updateNoteFCountCheckService(String fCountCheckId, String note) {
        return finalCountCheckDao.updateNoteFCountCheckDao(fCountCheckId, note);
    }
    //*********模糊搜索

    @Override
    public List<FinalCountCheck> searchFCountCheckService(String searchname, String searchValue) {
        return finalCountCheckDao.searchFCountCheckDao(searchname, searchValue);
    }

    //-------------------------工序计量质检--------------------------------------
    //************注入Dao
    @Autowired
    private ProcessMeasureCheckDao processMeasureCheckDao;

    //***********查询工序计量质检列表
    @Override
    public List<ProcessMeasureCheck> findPMeasureCheck() {
        List<ProcessMeasureCheck> list = processMeasureCheckDao.findPMeasureCheckDao();
        return list;
    }

    //**********添加工序计量质检记录
    @Override
    public int addPMeasureCheckService(ProcessMeasureCheck processMeasureCheck) {
        return processMeasureCheckDao.insertPMeasureCheckDao(processMeasureCheck);
    }
    //**********修改工序计量质检记录

    @Override
    public int updatePMeasureCheckService(ProcessMeasureCheck processMeasureCheck) {
        return processMeasureCheckDao.updatePMeasureCheckDao(processMeasureCheck);
    }
    //*********删除工序计量质检记录

    @Override
    public int deletePMeasureCheckService(String[] ids) {
        return processMeasureCheckDao.deletePMeasureCheckDao(ids);
    }
    //***********修改备注工序计量质检记录

    @Override
    public int updateNotePMeasureCheckService(String pMeasureCheckId, String note) {
        return processMeasureCheckDao.updateNotePMeasureCheckDao(pMeasureCheckId, note);
    }
    //**********模糊查询

    @Override
    public List<ProcessMeasureCheck> searchPMeasureCheckService(String searchname, String searchValue) {
        return processMeasureCheckDao.searchPMeasureCheckDao(searchname, searchValue);
    }


    //-------------------------工序计数质检--------------------------------------

    //************注入Dao
    @Autowired
    private ProcessCountCheckDao processCountCheckDao;
//    //***********查询工序计数质检列表

    @Override
    public List<ProcessCountCheck> findPCountCheckService() {
        return processCountCheckDao.findPCountCheckDao();
    }

//    //**********添加工序计数质检记录

    @Override
    public int addPCountCheckService(ProcessCountCheck processCountCheck) {
        return processCountCheckDao.insertPCountCheckDao(processCountCheck);
    }

//    //**********修改工序计数质检记录

    @Override
    public int updatePCountCheckService(ProcessCountCheck processCountCheck) {
        return processCountCheckDao.updatePCountCheckDao(processCountCheck);
    }

//    //*********删除工序计数质检记录

    @Override
    public int deletePCountCheckService(String[] ids) {
        return processCountCheckDao.deletePCountCheckDao(ids);
    }

//    //***********修改备注工序计量质检记录

    @Override
    public int updateNotePCountCheckService(String pCountCheckId, String note) {
        return processCountCheckDao.updateNotePCountCheckDao(pCountCheckId, note);
    }
    //***********模糊查询


    @Override
    public List<ProcessCountCheck> searchPCountCheckService(String searchname, String searchValue) {
        return processCountCheckDao.searchPCountCheckDao(searchname, searchValue);
    }

    /*****************人员监控接口实现*************************************/
    //部门
    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> findDepartment() {
        return departmentDao.selectDepartment();
    }

    @Override
    public Department findDepartmentById(String id) {
        return departmentDao.selectDepartmentById(id);
    }

    @Override
    public int addDepartment(Department department) {
        return departmentDao.insertDepartment(department);
    }

    @Override
    public int editDepartment(Department department) {
        return departmentDao.updateDepartment(department);
    }

    @Override
    public int deleteDepartment(String[] ids) {
        return departmentDao.deleteDepartmentById(ids);
    }

    //员工
    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employees = employeeDao.findAllEmployee();
        return employees;
    }

    @Override
    public int insertEmployee(Employee employee, String departmentId) {
        return employeeDao.insertEmployee(employee, departmentId);
    }

    @Override
    public int updateByPrimaryKey(Employee employee) {
        return employeeDao.updateByPrimaryKey(employee);
    }

    @Override
    public int deleteEmployee(String[] ids) {
        return employeeDao.deleteEmployee(ids);
    }

    @Override
    public List<Employee> queryByEmployeeId(String empId) {
        return employeeDao.queryByEmployeeId(empId);
    }

    @Override
    public Employee findEmployeeById(String empId) {
        return employeeDao.findEmployeeById(empId);
    }

    @Override
    public List<Employee> queryByEmployeeName(String empName) {
        return employeeDao.queryByEmployeeName(empName);
    }

    @Override
    public List<Employee> queryByDepartmentName(String departmentName) {
        return employeeDao.queryByDepartmentName(departmentName);
    }


    /*****************系统管理接口实现*************************************/
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public List<SysUser> findUser() {
        return sysUserDao.selectAllUser();
    }

    @Override
    public SysUser findUserById(String id) {
        return sysUserDao.selectAllUserById();
    }

    @Override
    public int addUser(SysUser sysUser) {
        return sysUserDao.insertUser(sysUser);
    }

    @Override
    public int editUser(SysUser user) {
        return sysUserDao.addUser(user);
    }

    @Override
    public int deleteUser(String[] ids) {
        return sysUserDao.deleteUserByIds(ids);
    }

    @Override
    public List<COrder> findUserBySearch(String condition, String searchValue) {
        return sysUserDao.selectUserBySearch(condition,searchValue);
    }

    @Override
    public SysUser findUserByUsernameAndPassword(String username, String password) {
        return sysUserDao.selectUserByUsernameAndPassword(username,password);
    }

    @Override
    public SysUser findUserByUsername(String username) {
        return sysUserDao.selectUsername(username);
    }
}
