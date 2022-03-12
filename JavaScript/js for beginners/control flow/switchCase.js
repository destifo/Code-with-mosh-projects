let role;

switch (role){
    case 'Student':
        console.log('Only read premissions');
        break;
    case 'parent':
        console.log('Some write and read permissions');
        break;
    default:
        console.log('almost all privileges');
}